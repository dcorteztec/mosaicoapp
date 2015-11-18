package br.com.mosaicomodel.model;

public enum Status {

	ATIVO("A"),
    INATIVO("I"),
    EXCLUIDO("E"),
    BLOQUEADO("B");
     
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
