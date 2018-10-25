package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.Periodo;
import service.PeriodoService;

@FacesConverter(forClass=Periodo.class)
public class PeriodoConverter implements Converter{

	private PeriodoService service = new PeriodoService();
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Periodo obj = null;
		if ((value != null) && (!value.isEmpty()) )
			obj = service.buscarPorCodigo(Integer.parseInt(value));		
		return obj;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null){
			Periodo aux = (Periodo)value;
			Integer cod = aux.getCodigo();
			return  cod.toString();
		}
		else 
		   return null;
	}	
	
}
