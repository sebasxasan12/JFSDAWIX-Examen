package pe.unjfsc.daw.spring5.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import pe.unjfsc.daw.spring5.entity.CERutaDTOEntrada;

public class CLRutaMapper implements FieldSetMapper<CERutaDTOEntrada> {
	private static final Logger MOLOG = LoggerFactory.getLogger(CLRutaMapper.class);

	@Override
	public CERutaDTOEntrada mapFieldSet(FieldSet poFieldSet) throws BindException {
		MOLOG.info("[DAW] =====[ Start mapFieldSet ]=====");
		MOLOG.info("[DAW] read record : {} ", poFieldSet.toString());

		CERutaDTOEntrada oCompraEntrada = new CERutaDTOEntrada();
		oCompraEntrada.setId(poFieldSet.readInt("ID"));
		oCompraEntrada.setEmpresa(poFieldSet.readString("EMPRESA"));
		oCompraEntrada.setRuc(poFieldSet.readInt("RUC"));
		oCompraEntrada.setDireccion(poFieldSet.readString("DIRECCION"));
		oCompraEntrada.setUbicacion(poFieldSet.readString("UBICACION"));
		oCompraEntrada.setFecha(poFieldSet.readString("FECHA"));
		oCompraEntrada.setHora(poFieldSet.readString("HORA"));
		oCompraEntrada.setTipo_comp(poFieldSet.readString("TIPO_COMPROBANTE"));
		oCompraEntrada.setN_comp(poFieldSet.readString("NUMERO_COMPROBANTE"));
		oCompraEntrada.setCategoria(poFieldSet.readString("CATEGORIA"));
		oCompraEntrada.setImporte(poFieldSet.readDouble("IMPORTE"));

		MOLOG.info("[DAW] Mapper to CERutaDTOEntrada : {}", oCompraEntrada.toString());

		return oCompraEntrada;

	}

}
