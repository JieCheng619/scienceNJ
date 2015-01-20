package test;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class TestExport {
@Test
public void exportTable(){
	Configuration cfg = new Configuration().configure();
	SchemaExport export = new SchemaExport(cfg);
	export.create(true,true);
}
}
