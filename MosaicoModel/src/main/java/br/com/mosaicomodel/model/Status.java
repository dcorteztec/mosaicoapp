package br.com.mosaicomodel.model;

public enum Status {

	ATIVO("Ativ0"),
    INATIVO("Inativ0"),
    EXCLUIDO("Excluido"),
    BLOQUEADO("Bloqueado");
     
    private String state;
     
    private Status(final String state){
        this.state = state;
    }
     
    public String getStatus(){
        return this.state;
    }
 
    @Override
    public String toString(){
        return this.state;
    }
 
 
    public String getName(){
        return this.name();
    }
 
}
