import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {	
	
	public static void main(String[] args) {			
		Menu();
	}
	
	public static void Menu() {
		Scanner ler = new Scanner(System.in);
		boolean loop = true;
		
		do {
			
			System.out.println("1� LISTA DE ATIVIDADES � PARADIGMAS DE L�GICA DE PROGRAMA��O");
			System.out.println("------------------------------------------------------------");
			System.out.println("[1] QUEST�O 1 - Cadastro de Pessoas");
			System.out.println("[2] QUEST�O 2 - Cadastro de Funcion�rios");
			System.out.println("[3] QUEST�O 3 - Ret�ngulo");
			System.out.println("[4] QUEST�O 4 - Funcion�rio e Sal�rio");
			System.out.println("[5] QUEST�O 5 - Aluno");
			System.out.println("------------------------------------------------------------");
            int key = ler.nextInt();
            
            switch (key)
            {
                case 1:
                	Questao1();
                    break;
                case 2:
                    Questao2();
                    break;
                case 3:
                    Questao3();
                    break;
                case 4:
                    Questao4();
                    break;
                case 5:
                    Questao5();
                    break;
                default:
                    System.out.println("Por favor, selecione uma das op��es descritas no menu!");
                    System.out.println("------------------------------------------------------");
                    Menu();
                    break;
            }
            
            System.out.println("----------------------------------------------------------");                      
            Menu();
            
		}while(loop);
	} 
	
	public static void Questao1()
    {
		Scanner ler = new Scanner(System.in);
		
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        Pessoa pessoa = new Pessoa();            

        System.out.println("Dados da primeira pessoa:");
        System.out.print("Nome: ");
        pessoa.setNome(ler.nextLine());
        System.out.print("Idade: ");
        pessoa.setIdade(Integer.parseInt(ler.nextLine()));
        pessoas.add(new Pessoa(pessoa.getNome(), pessoa.getIdade()));            
        
        System.out.println("Dados da segunda pessoa:");
        System.out.print("Nome: ");
        pessoa.setNome(ler.nextLine());
        System.out.print("Idade: ");
        pessoa.setIdade(Integer.parseInt(ler.nextLine()));
        pessoas.add(new Pessoa(pessoa.getNome(), pessoa.getIdade()));

        for (int i=0; i<= pessoas.size(); i++)
        {        	
            if(pessoas.get(i).getIdade() > pessoas.get(i + 1).getIdade())
            {
                System.out.println("Pessoa mais velha: " + pessoas.get(i).getNome());
                break;
            }
            else
            {
                System.out.println("Pessoa mais velha: " + pessoas.get(i + 1).getNome());
                break;
            }                    
        }           
    }
	
	public static void Questao2()
    {
		Scanner ler = new Scanner(System.in);
		
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Funcionario funcionario = new Funcionario();
        double _mediaSalarial = 0;

        System.out.println("Dados do primeiro funcion�rio:");
        System.out.print("Nome: ");
        funcionario.setNome(ler.nextLine());
        System.out.print("Sal�rio: ");
        funcionario.setSalarioBruto(Double.parseDouble(ler.nextLine()));
        funcionarios.add(new Funcionario(funcionario.getNome(), funcionario.getSalarioBruto()));

        System.out.println("Dados do segundo funcion�rio:");
        System.out.print("Nome: ");
        funcionario.setNome(ler.nextLine());
        System.out.print("Sal�rio: ");
        funcionario.setSalarioBruto(Double.parseDouble(ler.nextLine()));
        funcionarios.add(new Funcionario(funcionario.getNome(), funcionario.getSalarioBruto()));

        for(Funcionario list : funcionarios)
            _mediaSalarial += list.getSalarioBruto();

        System.out.println("Sal�rio m�dio = " + (_mediaSalarial / 2));
    }
	
	public static void Questao3()
    {         
		Scanner ler = new Scanner(System.in);
		
        System.out.println("Entre a altura e a largura do ret�ngulo: ");
        Retangulo retangulo = new Retangulo();
        retangulo.setAltura(Double.parseDouble(ler.nextLine()));
        retangulo.setLargura(Double.parseDouble(ler.nextLine()));
        Retangulo poligono = new Retangulo(retangulo.getLargura(), retangulo.getAltura());

        System.out.println("�rea: " + poligono.Area());
        System.out.println("Perimetro: " + poligono.Perimetro());
        System.out.println("Diagonal: " + poligono.Diagonal());
    }
	
	public static void Questao4() 
	{
		Scanner ler = new Scanner(System.in);
		        
        Funcionario funcionario = new Funcionario();        
        
        System.out.print("Nome: ");
        funcionario.setNome(ler.nextLine());
        System.out.print("Sal�rio Bruto: ");
        funcionario.setSalarioBruto(Double.parseDouble(ler.nextLine()));
        System.out.print("Imposto: ");
        funcionario.setImposto(Double.parseDouble(ler.nextLine()));
        
        System.out.println("Funcion�rio: " + funcionario.getNome() + ", R$ " + funcionario.SalarioLiquido());
        System.out.print("Digite a porcentagem para aumentar o sal�rio: ");
        double percentual = Double.parseDouble(ler.nextLine());
        funcionario.AumentarSalario(percentual);
        
        System.out.println("Dados atualizados: " + funcionario.getNome() + ", " + funcionario.SalarioLiquido());
	}
	
	public static void Questao5() 
	{
		Scanner ler = new Scanner(System.in);
		
		Aluno aluno = new Aluno();        
        double notaFinal = 0;
        
        for (int i = 0; i < 1; i++)
        {
        	System.out.print("Nome do Aluno: ");
            aluno.setNome(ler.nextLine());

            System.out.println("Digite as tr�s notas do aluno: ");
            for (int j = 0; j < 3; j++)
            {
                boolean loopNota = true;

                do
                {
                	System.out.print(String.format("%d� Trimestre: ", j + 1));
                	aluno.setNota(Double.parseDouble(ler.nextLine()));

                    switch (j)
                    {
                        case 0:
                            if (aluno.getNota() <= 30f)
                            {
                                notaFinal = (notaFinal + aluno.getNota());
                                loopNota = false;
                            }
                            else
                            	System.out.println("Nota inv�lida. Para esse semestre, o m�ximo � 30... Digite novamente!");
                            break;
                        default:
                            if (aluno.getNota() <= 35f)
                            {
                                notaFinal = (notaFinal + aluno.getNota());
                                loopNota = false;
                            }
                            else
                            	System.out.println("Nota inv�lida. Para esse semestre, o m�ximo � 35... Digite novamente!");
                            break;
                    }
                } while (loopNota);
            }
            
            System.out.print("\nNOTA FINAL = " + notaFinal);

            if (notaFinal <= 60f)
            	System.out.println("\nREPROVADO \nFALTARAM " + (60f - notaFinal));
            else
            	System.out.println("\n\nAPROVADO");
        }
	}
}
