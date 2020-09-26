package com.yicj.study.gen;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;


public class GeneratorSqlMapper {
	public void generator() throws Exception{
		List<String> warnings = new ArrayList<String>();
		boolean overWrite = true;
		//指定 逆向工程配置文件
		File configFile = Resources.getResourceAsFile("generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overWrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
				callback, warnings);
		myBatisGenerator.generate(null);
	}

	public static void main(String[] args) throws Exception {
		GeneratorSqlMapper generatorSqlMapper = new GeneratorSqlMapper();
		generatorSqlMapper.generator();
	}
}
