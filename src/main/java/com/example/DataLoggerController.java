package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
@CrossOrigin(origins = "*")
public class DataLoggerController {
	
	private DataLogger dataLogger;
	
	@Autowired	
	public DataLoggerController(DataLogger dataLogger) {
		super();
		this.dataLogger = dataLogger;
	}

	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> addData(@RequestBody Data data) {
        if (data != null) {
        	dataLogger.addData(data);
        	return new ResponseEntity<String>(HttpStatus.OK);
        } else {
        	return new ResponseEntity<String>("Data cannot be null", HttpStatus.BAD_REQUEST);
        }
    }
    
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Data>> getData(
			@RequestParam(value="from", required=false) Long from,
			@RequestParam(value="to", required=false) Long to) {
		long first = 0;
		long last = Long.MAX_VALUE;
		if (from != null) {
			first = from;
		}
		if (to != null) {
			last = to;
		}
		if (last < first) {
			return new ResponseEntity<List<Data>>(new ArrayList<Data>(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Data>>(dataLogger.getData(first, last), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> removeData(@RequestParam(value="timestamp", required=true) Long timestamp) {
		dataLogger.removeData(new Data(timestamp));
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
