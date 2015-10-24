package to;

import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ListagemAeroportoTO extends ArrayList<AeroportoTO> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String toJSON(){
		JSONArray v = new JSONArray();
		for(AeroportoTO to:this){
			JSONObject obj = new JSONObject();
			try {
				obj.put("id", to.id);
				obj.put("codigo", to.codigo);
				obj.put("nome", to.nome);
				obj.put("nomeCompleto",to.nomeCompleto);
				obj.put("pais",to.pais);
				obj.put("estado",to.estado);
				v.put(obj);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return v.toString();	
	}


}

