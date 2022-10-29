package pe.unjfsc.daw.spring5.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CVLanzarJob {
	private static final Logger MOLOG = LoggerFactory.getLogger(CVLanzarJob.class);
	private static ApplicationContext moContext;
	private static String[] configJob = { "classpath:/batch/jobs/job03-define-jobs.xml" };

	public static void main(String[] args) {
		MOLOG.info("[DAW]=====[ Start main ]=====");

		moContext = new ClassPathXmlApplicationContext(configJob);
		MOLOG.info("[DAW] ClassPathXmlApplicationContext {}", moContext);

		JobLauncher jobLauncher = (JobLauncher) moContext.getBean("idJobLauncher");
		MOLOG.info("[DAW] JobLauncher {}", jobLauncher);

		Job job = (Job) moContext.getBean("idFirstJobBatch");
		MOLOG.info("[DAW] Job {}", job);

		JobExecution jobExecution = null;

		try {
			jobExecution = jobLauncher.run(job, new JobParameters());
			MOLOG.info("[DAW] jobExecution        : {}", jobExecution);
			MOLOG.info("[DAW] Estatus        : {}", jobExecution.getStatus());
			MOLOG.info("[DAW] Estatus Salida : {}", jobExecution.getExitStatus());

		} catch (Exception e) {
			MOLOG.error("[DAW] Error al ejecutar el JOB : {}", e.getMessage());
		}
		((ConfigurableApplicationContext) moContext).close();
	}

}
