package pe.unjfsc.daw.spring5.writer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import pe.unjfsc.daw.spring5.entity.CERutaDTOSalida;
import pe.unjfsc.daw.spring5.process.CLRutaProcessor;

public class CDRutaWriter implements ItemWriter<CERutaDTOSalida> {
	private static final Logger LOG = LoggerFactory.getLogger(CDRutaWriter.class);
	public CLRutaProcessor oClRutaProcessor = new CLRutaProcessor();

	@Override
	public void write(List<? extends CERutaDTOSalida> poItemsSalida) throws Exception {
		LOG.info("[DAW] =====[ Start write ]=====");

		LOG.info("[DAW] Object output : {} ", poItemsSalida.toString());

		for (CERutaDTOSalida item : poItemsSalida) {
			LOG.info("[DAW] Item read  : {}", item.toString());
			oClRutaProcessor.datos(item);
		}
		oClRutaProcessor.convertir();
	}

}
