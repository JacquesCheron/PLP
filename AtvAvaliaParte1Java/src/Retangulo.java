public class Retangulo {
	
	private double _altura;
    private double _largura;  
    
    public double getAltura() { return _altura;	}
    public void setAltura(double value) { _altura = value; }
    
    public double getLargura() { return _largura; }
    public void setLargura(double value) { _largura = value; }

    public Retangulo() { }

    public Retangulo(double largura, double altura)
    {
    	_largura = largura;
        _altura = altura;
    }

    public double Area()
    {
        return _largura * _altura;
    }

    public double Perimetro()
    {
        return 2 * (_largura + _altura);
    }

    public double Diagonal()
    {
        return Math.sqrt((_altura * _altura) + (_largura * _largura));
    }
	
}
