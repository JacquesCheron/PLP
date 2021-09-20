public class Funcionario extends Pessoa {
	
	private double _salarioBruto;
    private double _imposto;   
    
    public double getSalarioBruto() { return _salarioBruto;	}
    public void setSalarioBruto(double value) { _salarioBruto = value; }
    
    public double getImposto() { return _imposto; }
    public void setImposto(double value) { _imposto = value; }
    
    public Funcionario() { }
    
    public Funcionario(String nome, double salarioBruto)
    {
        _nome = nome;
        _salarioBruto = salarioBruto;
    }
    
    public double SalarioLiquido()
    {
        return _salarioBruto - _imposto;
    }

    public void AumentarSalario(double porcentagem)
    {
    	_salarioBruto = _salarioBruto + (((_salarioBruto * porcentagem) / 100));
    }
}
