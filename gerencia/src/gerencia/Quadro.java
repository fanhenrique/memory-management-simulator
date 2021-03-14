package gerencia;

public class Quadro {

    private int idQuadro; // Identificador do quadro
    private boolean estado = false; // Controla se o quadro esta ou não sendo usado
    private final int tamanho = 4; //Tamanho dos quadros 4KB

    public void setIdQuadro(int id){
        idQuadro = id;
    }
    
    public int getTamanho() {
        return tamanho;
    }
 
    public int getIdQuadro(){
        return idQuadro;
    }
    
    //Printa o id do quadro
    @Override
    public String toString(){
       return "QD" + idQuadro;
    }
    
    public boolean getEstado(){
        return estado;
    }
    
    public void setEstado(boolean estado){
        this.estado = estado;
    }
}
