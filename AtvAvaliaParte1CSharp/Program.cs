using System;
using System.Collections.Generic;

namespace AtvAvaliaParte1
{
    class Program
    {
        static void Main(string[] args)
        {
            Menu();
        }

        public static void Menu()
        {
            bool loop = true;

            do
            {
                Console.WriteLine("1ª LISTA DE ATIVIDADES – PARADIGMAS DE LÓGICA DE PROGRAMAÇÃO");
                Console.WriteLine("------------------------------------------------------------");
                Console.WriteLine("[1] QUESTÃO 1 - Cadastro de Pessoas");
                Console.WriteLine("[2] QUESTÃO 2 - Cadastro de Funcionários");
                Console.WriteLine("[3] QUESTÃO 3 - Retângulo");
                Console.WriteLine("[4] QUESTÃO 4 - Funcionário e Salário");
                Console.WriteLine("[5] QUESTÃO 5 - Aluno");
                Console.WriteLine("------------------------------------------------------------");
                string key = Console.ReadLine();
                Console.Clear();

                switch (key)
                {
                    case "1":
                        Questao1();
                        break;
                    case "2":
                        Questao2();
                        break;
                    case "3":
                        Questao3();
                        break;
                    case "4":
                        Questao4();
                        break;
                    case "5":
                        Questao5();
                        break;
                    default:
                        Console.WriteLine("Por favor, selecione uma das opções descritas no menu!");
                        Console.WriteLine("------------------------------------------------------");
                        Menu();
                        break;
                }

                Console.WriteLine("----------------------------------------------------------");
                Console.WriteLine("Pressione qualquer tecla para voltar ao menu principal ...");
                Console.ReadKey();
                Console.Clear();
                Menu();

            } while (loop);
        }

        public static void Questao1()
        {
            List<Pessoa> pessoas = new List<Pessoa>();
            Pessoa pessoa = new Pessoa();            

            Console.WriteLine("Dados da primeira pessoa:");
            Console.Write("Nome: ");
            pessoa.Nome = Console.ReadLine();
            Console.Write("Idade: ");
            pessoa.Idade = Convert.ToInt16(Console.ReadLine().Replace(".", ","));
            pessoas.Add(new Pessoa(pessoa.Nome, pessoa.Idade));            

            Console.WriteLine("Dados da segunda pessoa:");
            Console.Write("Nome: ");
            pessoa.Nome = Console.ReadLine();
            Console.Write("Idade: ");
            pessoa.Idade = Convert.ToInt16(Console.ReadLine().Replace(".", ","));
            pessoas.Add(new Pessoa(pessoa.Nome, pessoa.Idade));

            for (int i = 0; i < pessoas.Count;)
            {
                if(pessoas[i].Idade > pessoas[i + 1].Idade)
                {
                    Console.WriteLine("Pessoa mais velha: " + pessoas[i].Nome);
                    break;
                }
                else
                {
                    Console.WriteLine("Pessoa mais velha: " + pessoas[i + 1].Nome);
                    break;
                }                    
            }           
        }

        public static void Questao2()
        {
            List<Funcionario> funcionarios = new List<Funcionario>();
            Funcionario funcionario = new Funcionario();
            double _mediaSalarial = 0;

            Console.WriteLine("Dados do primeiro funcionário:");
            Console.Write("Nome: ");
            funcionario.Nome = Console.ReadLine();
            Console.Write("Salário: ");
            funcionario.SalarioBruto = Convert.ToDouble(Console.ReadLine().Replace(".", ","));
            funcionarios.Add(new Funcionario(funcionario.Nome, funcionario.SalarioBruto));

            Console.WriteLine("Dados do segundo funcionário:");
            Console.Write("Nome: ");
            funcionario.Nome = Console.ReadLine();
            Console.Write("Salário: ");
            funcionario.SalarioBruto = Convert.ToDouble(Console.ReadLine().Replace(".", ","));
            funcionarios.Add(new Funcionario(funcionario.Nome, funcionario.SalarioBruto));

            foreach (var item in funcionarios)
                _mediaSalarial += item.SalarioBruto;

            Console.WriteLine("Salário médio = " + (_mediaSalarial / 2).ToString("F2").Replace(",", "."));
        }

        public static void Questao3()
        {           
            Console.WriteLine("Entre a altura e a largura do retângulo: ");
            Retangulo retangulo = new Retangulo();
            retangulo.Altura = Convert.ToDouble(Console.ReadLine().Replace(".", ","));
            retangulo.Largura = Convert.ToDouble(Console.ReadLine().Replace(".", ","));
            Retangulo poligono = new Retangulo(retangulo.Largura, retangulo.Altura);

            Console.WriteLine("Área: " + poligono.Area().ToString("F2").Replace(",", "."));
            Console.WriteLine("Perimetro: " + poligono.Perimetro().ToString("F2").Replace(",", "."));
            Console.WriteLine("Diagonal: " + poligono.Diagonal().ToString("F2").Replace(",", "."));
        }

        public static void Questao4()
        {
            Funcionario funcionario = new Funcionario();
            Console.Write("Nome: ");
            funcionario.Nome = Console.ReadLine();
            Console.Write("Salário bruto: ");
            funcionario.SalarioBruto = Convert.ToDouble(Console.ReadLine().Replace(".", ","));
            Console.Write("Imposto: ");
            funcionario.Imposto = Convert.ToDouble(Console.ReadLine().Replace(".", ","));

            Console.WriteLine("Funcionário: " + funcionario.Nome + ", R$ " + funcionario.SalarioLiquido().ToString("F2").Replace(",", "."));
            Console.Write("Digite a porcentagem para aumentar o salário: ");
            double porcentAumentarSalario = Convert.ToDouble(Console.ReadLine().Replace(".", ","));
            funcionario.AumentarSalario(porcentAumentarSalario);

            Console.WriteLine("Dados atualizados: " + funcionario.Nome + ", " + funcionario.SalarioLiquido().ToString("F2").Replace(",", "."));
        }

        public static void Questao5()
        {
            Aluno aluno = new Aluno();
            aluno.Notas = new double[3];
            double notaFinal = 0;

            for (int i = 0; i < 1; i++)
            {
                Console.Write("Nome do Aluno: ");
                aluno.Nome = Console.ReadLine();

                Console.WriteLine("Digite as três notas do aluno: ");
                for (int j = 0; j < aluno.Notas.Length; j++)
                {
                    bool loopNota = true;

                    do
                    {
                        Console.Write(string.Format("{0}º Trimestre: ", j + 1));
                        aluno.Notas[j] = Convert.ToDouble(Console.ReadLine().Replace(".", ","));

                        switch (j)
                        {
                            case 0:
                                if (aluno.Notas[j] <= 30f)
                                {
                                    notaFinal = (notaFinal + aluno.Notas[j]);
                                    loopNota = false;
                                }
                                else
                                    Console.WriteLine("Nota inválida. Para esse semestre, o máximo é 30... Digite novamente!");
                                break;
                            default:
                                if (aluno.Notas[j] <= 35f)
                                {
                                    notaFinal = (notaFinal + aluno.Notas[j]);
                                    loopNota = false;
                                }
                                else
                                    Console.WriteLine("Nota inválida. Para esse semestre, o máximo é 35... Digite novamente!");
                                break;
                        }
                    } while (loopNota);
                }

                Console.Write("\nNOTA FINAL = " + notaFinal.ToString("F2").Replace(",", "."));

                if (notaFinal <= 60f)
                    Console.WriteLine("\nREPROVADO \nFALTARAM " + (60f - notaFinal).ToString("F2") + " PONTOS");
                else
                    Console.WriteLine("\n\nAPROVADO");
            }
        }
    }
}
