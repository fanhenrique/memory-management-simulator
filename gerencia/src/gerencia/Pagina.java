package gerencia;

public class Pagina {
    
    private int idPagina; // Identificador da paǵina
    private final int tamanho = 4; //Tamanho da página 4KB
 
    public void setIdPagina(int id){
        idPagina = id;
    }
    
    public int getIdPagina(){
        return idPagina;
    }
    
    public int getTamanho() {
        return tamanho;
    }

    //Printa id da página
    @Override
    public String toString(){
        return "PG " + idPagina;
    }
    
}
