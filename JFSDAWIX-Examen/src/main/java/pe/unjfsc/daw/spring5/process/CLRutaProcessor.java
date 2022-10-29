package pe.unjfsc.daw.spring5.process;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.unjfsc.daw.spring5.entity.*;

public class CLRutaProcessor implements ItemProcessor<CERutaDTOEntrada, CERutaDTOSalida> {
	private static final Logger MOLOG = LoggerFactory.getLogger(CLRutaProcessor.class);
	private List<CERutaDTOSalida> ls = new ArrayList<CERutaDTOSalida>();
	@Override
	public CERutaDTOSalida process(CERutaDTOEntrada poItemRuta) throws Exception {
		MOLOG.info("[DAW] =====[ Start process ]=====");
		MOLOG.info("[DAW] Data received input : {} ", poItemRuta.toString());
		CERutaDTOSalida oRutaSalida = new CERutaDTOSalida();
		oRutaSalida.setId(poItemRuta.getId());
		oRutaSalida.setEmpresa(poItemRuta.getEmpresa());
		oRutaSalida.setRuc(poItemRuta.getRuc());
		oRutaSalida.setDireccion(poItemRuta.getDireccion());
		oRutaSalida.setUbicacion(poItemRuta.getUbicacion());
		oRutaSalida.setFecha(poItemRuta.getFecha());
		oRutaSalida.setHora(poItemRuta.getHora());
		oRutaSalida.setTipo_comp(poItemRuta.getTipo_comp());
		oRutaSalida.setN_comp(poItemRuta.getN_comp());
		oRutaSalida.setCategoria(poItemRuta.getCategoria());
		oRutaSalida.setImporte(poItemRuta.getImporte());
		oRutaSalida.setIgv(igv(poItemRuta));
		oRutaSalida.setTotaligv(totaligv(oRutaSalida));

		MOLOG.info("[DAW] New CERutaDTOSalida : {} ", oRutaSalida.toString());

		return oRutaSalida;
	}

	public double igv(CERutaDTOEntrada objeto) {
		return (objeto.getImporte() * 0.18);
	}

	public double totaligv(CERutaDTOSalida objeto) {
		return (objeto.getIgv() + objeto.getImporte());
	}
	
	public void datos(CERutaDTOSalida objeto) {
		ls.add(objeto);
	}
	
	public void convertir() {
		String path = "Rutas.json";

		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File(path), ls);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
