package sample.demo1.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TimeMapper {
	
	@Select("select sysdate from dual")
	public String getTime();
}
