package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.TestDTO;
import poly.persistance.mapper.ComMapper;
import poly.service.IComService;

@Service("ComService")
public class ComService implements IComService{
	
	@Resource(name="ComMapper")
	private ComMapper ComMapper;

	@Override
	public void InsertVal(TestDTO t) throws Exception {
		ComMapper.insertVal(t);
	}
	
		
}

