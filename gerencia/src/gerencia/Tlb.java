package gerencia;

import java.util.ArrayList;

public class Tlb {
    
    private int[] pg; // Indices das páginas
    private boolean[] validade; // Quais linhas da memória virtual estão liberadas
    private int[] qd; //Indices dos quadros
    private int miss; // TLB miss
    private int hit; //TLB hit    
    
    public Tlb(int t){
        pg = new int[t];
        qd = new int[t];
        validade = new boolean[t];
        miss = 0;
        hit = 0;
        
        for(int i = 0; i < pg.length; i++){
              pg[i] = -1;
              qd[i] = -1;
        }
    }
    //adiciona uma página na tlb
    public void putTlb(Pagina p, int quadro){
        boolean flag = false;
        
        // Verifica se tem algum espaço na memória TBL livre
        for(int i = 0; i < pg.length; i++){
            if(p.getIdPagina() == pg[i]){
                flag = true;
            }
        }
        
        // Coloca uma página na TLB
        if(flag == false){
            for(int i = 0; i < pg.length; i++){
                if(validade[i] == false){ 
                    validade[i] = true;
                    pg[i] = p.getIdPagina();
                    qd[i] = quadro;
                    break;
                }
            }
        }    
    }
    //remove da tlb se a página vai para tlb
    public void liberaTlbSwap(int p){
                
        for(int i = 0; i < pg.length; i++){
            if(p == pg[i]){
                validade[i] = false;
                pg[i] = -1;
                qd[i] = -1;
            }
        }
                
    }
    //remove um página pelo índice
    public void liberaTlb(int p){
                validade[p] = false;
                pg[p] = -1;
                qd[p] = -1;
    }
    //remove um página
    public void liberaTlb(Pagina p){
        
        for(int i = 0; i < pg.length; i++){
            if(p.getIdPagina() == pg[i]){
                validade[i] = false;
                pg[i] = -1;
                qd[i] = -1;
            }
        } 
    }
    //verifica se página ta na tlb
    public boolean verifica(Pagina p){
        boolean flag = false;
        for(int i = 0; i < pg.length; i++){
            if(p.getIdPagina() == pg[i]){
                flag = true;
            }
        }    
        return flag;
    } 
    //verifica se a tlb esta cheia
    public boolean tlbCheia()
    {
        for(int i = 0; i < pg.length; i++)
        {
            if(pg[i] == -1)
                return false;
        }
        return true;
    }
    //retorna um página
    public int getPg(int i){
        return pg[i];
    }
    //retorna um quadro
    public int getQd(int i){
        return qd[i];
    }
    
    public int getPgTam(){
        return pg.length;
    }
    //incrementa hit
    public void increasingHit(){
        this.hit++;
    }
    //incremanta miss
    public void increasingMiss(){
        this.miss++;
    }
    //retorna hit
    public int getHit(){
        return hit;
    }
    //retorna miss
    public int getMiss(){
        return miss;
    }
    //limpa miss e hit
    public void clear(){
        hit = 0; miss = 0;
    }
    
}
