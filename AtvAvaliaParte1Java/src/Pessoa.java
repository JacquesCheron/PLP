public class Pessoa {	
	
	protected String _nome;
    protected int _idade;
    
    public String getNome() { return _nome;	}
    public void setNome(String value) { _nome = value; }
    
    public int getIdade() { return _idade;	}
    public void setIdade(int value) { _idade = value; }
    
    public Pessoa() { }

    public Pessoa(String nome, int idade)
    {
    	_nome = nome;
    	_idade = idade;
    }
}
