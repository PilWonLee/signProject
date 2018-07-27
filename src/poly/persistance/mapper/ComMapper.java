package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.TestDTO;

@Mapper("ComMapper")
public interface ComMapper {

	void insertVal(TestDTO t) throws Exception;

	
}
