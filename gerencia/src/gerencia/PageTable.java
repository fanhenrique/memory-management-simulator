package gerencia;

public class PageTable {

    private int[] pg; // Indices das páginas
    private boolean[] validade; // Quais linhas da memória virtual estão liberadas
    private int[] qd; //Indices dos quadros
    private Memoria memoria; //Memória Física
    
    // Define o tamanho da memória física e virtual
    public PageTable(int tmv, int tmf){
        
        pg = new int[tmv];
        qd = new int[tmv];
        for(int i = 0; i < tmv; i++){
            pg[i] = -1;
            qd[i] = -1;
        }
        validade = new boolean[tmv];
        memoria = new Memoria(tmf);
    }
    
    // Coloca a uma página na memória virtual
    public boolean put(Pagina p){
        
        boolean flag = false;
        
        // Verifica se tem algum espaço na memória virtual livre
        for(int i = 0; i < pg.length; i++){
            if(p.getIdPagina() == pg[i]){
                flag = true;
            }
        }
        // 
        if(flag == false){
            for(int i = 0; i < pg.length; i++){
                if(validade[i] == false){
                    validade[i] = true;
                    pg[i] = p.getIdPagina();
                    qd[i] = memoria.getQuadro().getIdQuadro();
                    break;
                }
            }
        }
        return flag;
    }
    //Não ta usando
    public void setPgIndice(int indice, int valor)
    {
        pg[indice] = valor;
    }
    public void liberaProc(Pagina p){
        
        for(int i = 0; i < pg.length; i++){
            if(p.getIdPagina() == pg[i]){
                
                memoria.LiberaQuadro(qd[i]);
                
                validade[i] = false;
                pg[i] = -1;
                qd[i] = -1;
                
            }
        } 
        
    }
    
    public void removePg(int indice)
    {                
        memoria.LiberaQuadro(qd[indice]);

        validade[indice] = false;
        pg[indice] = -1;
        qd[indice] = -1;            
     }
    
    public boolean estaCheia()
    {
        for(int i = 0; i < pg.length; i++)
        {
            if(pg[i] == -1)
                return false;
        }
        return true;
    }
 
    public int getPg(int i)
    {
        return pg[i];
    }
    
    public int getQd(int i)
    {
        return qd[i];
    }
    
    public int getQdPg(Pagina p)
    {
        for(int i = 0; i < pg.length; i++){
            if(p.getIdPagina() == pg[i]){
                return qd[i];
            }
        }
        
        return -1;
    }
    
    public int getPgTam()
    {
        return pg.length;
    }
    public void printTable(){
        
        System.out.println("----------------------------------------------");
        for(int i = 0; i < pg.length; i++){
            System.out.println(validade[i] + " " + pg[i] + " " + qd[i]);
        }
        
    }
    
    
}
