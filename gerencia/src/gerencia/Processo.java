package gerencia;

import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Random;

public class Processo {
    
    private int idProcesso; //identificador do processo
    private int tDuracao; //Tempo de duaração do processo 
    private int qtPaginas; //quantidade de páginas
    public static int seqPg = 0; // Determina o id do processo (PARA NÃO REPETIR OS ID DA PÁGINA)
    public boolean acabou = false; // Determina se o processo acabou
    private int indSeq = 0; // Determina a página atual
    private Pagina[] paginas; // Todas as páginas do processo
    private Pagina[] sequencia; // Sequência de páginas do processo
    private Random random = new Random();

    //Cria as página e a sequência de execução
    public Processo(int idProcesso){  
        
        //O processo pode ter até 7 páginas
        int tamanho = random.nextInt(24)+2; 
        if(tamanho % 4 == 0)
            qtPaginas = tamanho / 4; 
        else
            qtPaginas = (tamanho / 4)+1;        
        
        // Cria as páginas do processo
        paginas = new Pagina[qtPaginas];
        for(int i = 0; i < qtPaginas; i++){
            Pagina p = new Pagina();
            p.setIdPagina(seqPg);
            paginas[i] = p;
            seqPg++;
        }
                
        // Determina a sequência de execução das páginas
        this.tDuracao = qtPaginas + random.nextInt(10);
        sequencia = new Pagina[tDuracao];
        for(int i = 0; i < tDuracao; i++){
            int x = random.nextInt(qtPaginas);
            sequencia[i] = paginas[x];
        }
        
        /*Garante que tenha pelo menos uma execução de cada página
          copia as páginas para o começo
        */
        for(int i = 0; i < qtPaginas; i++){
            //int x = random.nextInt(qtPaginas);
            sequencia[i] = paginas[i];
        }
        
        this.idProcesso = idProcesso;
    }
    //Retorna o id
    public int getIdProcesso() {
        return idProcesso;
    }
    //Retorna o tempo de duração
    public int getDuracao() {
        return tDuracao;
    }
    
    // ################# NÃO TA SENDO USADO #####################
    //public void setIdPg(int indice, int valor)
    //{
    //    sequencia[indice].setIdPagina(valor);
    //}
    // ################# NÃO TA SENDO USADO #####################
   // public void setIndice(int valor)
   // {
   //     indSeq = valor;
   // }
        
    //O processo acabou
    public void setAcabou(boolean valor){
        acabou = valor;
    }
    //Retorna a sequência das páginas
    public Pagina[] getPaginas(){
        return sequencia;
    }
    // Incrementa a sequência de execução do processo
    public void incrementaIndice(){
        indSeq++;
    }
    
    // Retorna o página atual do processo
    public int getIndice(){
        return indSeq;
    }
    
    // Printa o id, duração, página e a sequência de execução
    @Override 
    public String toString(){
        String a = "Processo " + idProcesso + "\tDuracao " + tDuracao + "\n";
        for(int i = 0; i < paginas.length; i++){
           a = a + paginas[i].toString()+ " ";   
        }
        
        a = a + "\n"; 
        
        for(int i = 0; i < sequencia.length; i++){
            a = a + sequencia[i].toString() + " ";
        }
        
        return a;
    }
    
}