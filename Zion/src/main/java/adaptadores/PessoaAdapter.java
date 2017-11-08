package adaptadores;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import model.entities.Pessoa;

public class PessoaAdapter extends TypeAdapter<Pessoa> {

    @Override
    public void write(JsonWriter writer, Pessoa value) throws IOException {
        writer.beginObject();
        
        
        

     	writer.name("id").value(value.getId());
        
        writer.name("descricao").value(value.getDescricao());
        writer.name("fantasia_Apelido").value(value.getFantasia_Apelido());
        writer.name("identificador").value(value.getCpf_Cnpj());
        writer.name("dataNascimento").value(value.getDataNascimento().toString());
        writer.name("cpf_Cnpj").value(value.getCpf_Cnpj());
        writer.name("rg_Insc").value(value.getRg_Insc());
        writer.name("sexo").value(value.getSexo().getAbrev());
        writer.name("fone_1").value("");
        writer.name("fone_2").value("");
        writer.name("fone_3").value("");
        writer.name("fone_4").value("");
        writer.name("fone_5").value("");
        writer.name("email").value("");
        
        
        if(value.getId_Profissao()!=null)
        writer.name("id_Profissao").value(value.getId_Profissao().getDescricao());
        
        
        writer.name("fcm_Tokem").value("");
        
        
        
        
        
        
       
               
        if (value.getId_Pessoa_Registro() != null) 
            writer.name("id_Pessoa_Registro").value(value.getId_Pessoa_Registro().getId());
        
        
        if (value.getEnum_Aux_Tipo_Pessoa() != null) {
            writer.name("enum_Aux_Tipo_Pessoa").value(value.getEnum_Aux_Tipo_Pessoa().getDescricao());
        }
        
        
        writer.endObject();
    }

    @Override
    public Pessoa read(JsonReader in) throws IOException {
        // do something you need
        return null;
    }

}