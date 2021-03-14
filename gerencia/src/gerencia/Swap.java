package gerencia;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Swap {
    
    ArrayList<Integer> paginas = new ArrayList<>();
    
    //Método para adicionar páginas a swap
    public void addPg(int valor)
    {
        int i;
        for(i = 0; i < paginas.size(); i++)
        {
            if(paginas.get(i) == valor)
                break;
        }
        if(i == paginas.size())
            paginas.add(valor);
    }
    
    //Método get para verificar se a página está na swap
    public Pagina getPg(Pagina p)
    {
        for(int i = 0; i < paginas.size(); i++)
        {
            if(paginas.get(i) == p.getIdPagina())
                return p;
        }
        return null;
    }
    
    //Méotodo para remover páginas da swap
    public void removePg(Pagina p, DefaultTableModel tabelaSwap)
    {
        for(int i = 0; i < paginas.size(); i++)
        {
            if(paginas.get(i) == p.getIdPagina())
            {
               tabelaSwap.removeRow(i);
               paginas.remove(i);
            }
               
        }
    }
    
    //Método para zerar a swap
    public void limpa()
    {
        paginas.clear();
    }
   
}
