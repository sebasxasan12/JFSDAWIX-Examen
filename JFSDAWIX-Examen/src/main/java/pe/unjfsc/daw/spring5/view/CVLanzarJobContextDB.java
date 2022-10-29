package pe.unjfsc.daw.spring5.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class CVLanzarJobContextDB {
	private static final Logger MOLOG = LoggerFactory.getLogger(CVLanzarJobContextDB.class);
	private static ApplicationContext moContext;
	private static String[] configJob = { "classpath:/batch/config/job01-database.xml" };

	public static void main(String[] psaLista) {
		MOLOG.info("[EVL] =====[ Start main ]=====");

		MOLOG.info("[EVL] psaLista : {}", psaLista.length);

		moContext = new ClassPathXmlApplicationContext(configJob);
		MOLOG.info("[EVL] moContext : {}", moContext);

		SingleConnectionDataSource oCxn = (SingleConnectionDataSource) moContext.getBean("dataSource");
		MOLOG.info("[EVL] Instance SingleConnectionDataSource : {}", oCxn.getUrl());

		DataSourceTransactionManager oTrn = (DataSourceTransactionManager) moContext.getBean("transactionManager");
		MOLOG.info("[EVL] Instance DataSourceTransactionManager : {}", oTrn.getDataSource());

		((ConfigurableApplicationContext) moContext).close();

	}

}
