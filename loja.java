package Sistema_Comercial;

/*
*Importando os métodos de entrada,
*e de manipulação de arquivos
*/

//---------#---------#-----------
//*Importação de Métodos
//---------#---------#-----------

import java.util.*;
import java.io.*;

/*
*---------#---------#---------#--------#--------#------////
*                   #LojaCoding
*        @Daniel Santos, @Nykollas Regis
*---------#---------#---------#--------#--------#------////
*/

//-------------##------------------##-----------------##--------------------##-----------------##---------------------##-----------------

public class LojaCoding {

//-------------##------------------##-----------------##--------------------##-----------------##---------------------##-----------------

    public static void escreverProduto(int codigo, float preco,int estoqueMax,float custoRepo,int estoque) throws Exception{
        File file = new File("src//Sistema_Comecial//database//produtos" + String.valueOf(codigo));
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter filebuffW = new BufferedWriter(fileWriter);
        
	    filebuffW.write( String.valueOf(preco) + '\n');
	    filebuffW.write( String.valueOf(estoqueMax) + '\n');
	    filebuffW.write( String.valueOf(custoRepo) + '\n');
	    filebuffW.write( String.valueOf(estoque) + '\n');
	
	    filebuffW.close();
    }

//-------------##------------------##-----------------##--------------------##-----------------##---------------------##-----------------

    public static int[] lerProduto(int codigo) throws IOException{
        File file = new File("src//Sistema_Comecial//database//produtos" + String.valueOf(codigo));
        FileReader fileReader = new FileReader(file);
        BufferedReader filebuffR = new BufferedReader(fileReader);
        
        int listaDeValores[] = new int[4];
        
	    listaDeValores[0] = Integer.parseInt(filebuffR.readLine());    //preço
	    listaDeValores[1] = Integer.parseInt(filebuffR.readLine());    //estoque máximo
	    listaDeValores[2] = Integer.parseInt(filebuffR.readLine());    //custo de reposição 
	    listaDeValores[3] = Integer.parseInt(filebuffR.readLine());    //qtd. de estoque
        
       return listaDeValores; 
    }

//-------------##------------------##-----------------##--------------------##-----------------##---------------------##-----------------

    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
     
      //abrindo o statusLoja.txt
        File file = new File("src//Sistema_Comercial//statusLoja.txt");
        
      //variáveis para ler/escrever o arquivo
        FileReader fileReader;
        BufferedReader filebuffR;
        FileWriter fileWriter;
        BufferedWriter filebuffW;
        
      //variáveis auxiliares
        int opcao = 0;       //recebe a opção do menu
        int codigo;          //recebe o código
        char desejo;         //recebe algo para confirmar ('s' ou 'n')
        int[] listaDeDados;  //recebe o retorno da função (lerProduto)
        
      //Variáveis para armazenar os dados de um produto
        float preco;      //preço
        int estoqueMax;   //estoque máximo
        float custoRepo;  //custo de reposição
        int qtdEstoque;   //quantidade no estoque
                    
      //Abrindo o arquivo 'statusLoja.txt' para ler
        fileReader = new FileReader(file);
        filebuffR = new BufferedReader(fileReader);
      
      //Lendo o conteúdo do 'statusLoja.txt'
        float lucroTotal   = Float.parseFloat(filebuffR.readLine()); //recebendo lucroTotal
        float custoTotal   = Float.parseFloat(filebuffR.readLine()); //recebendo custoTotal
        float receitaTotal = Float.parseFloat(filebuffR.readLine()); //recebendo receitaTotal
        int qtdProdutos    = Integer.parseInt(filebuffR.readLine()); //recebendo qtdProdutos
        
        fileReader.close();
        
        System.out.println("##################################");
        System.out.println("######   Sistema Comercial  ######");
        System.out.println("##################################");
	
        while(opcao != 7)
        {
            System.out.println("\nMenu");
            System.out.println("1. Vender um Produto");
            System.out.println("2. Cadastrar um Produto");
            System.out.println("3. Consultar Banco de Dados");
            System.out.println("4. Verificar Relatório de Vendas");
            System.out.println("5. Verificar Relatório de Reposição");
            System.out.println("6. Status da Loja");
            System.out.println("7. Sair");
	
            System.out.print("\nComando: ");
            opcao = input.nextInt();
		
        switch(opcao){
            case 1:
                System.out.println("Aguarde...");
                Thread.sleep(1000);   
                System.out.println("\n###########  Vender Produto  ###########");
                
                System.out.print("\nCódigo: ");
                codigo = input.nextInt();
                
                if(codigo > 0 && codigo < qtdProdutos){
                    listaDeDados = lerProduto(codigo);
                    
                    preco = listaDeDados[0];
                    estoqueMax = listaDeDados[1];
                    custoRepo = listaDeDados[2];
                    qtdEstoque = listaDeDados[3];
                    
                    if (qtdEstoque > 0) {
                    	System.out.print("Quantos produtos deseja comprar: ");
                        int qtdVendProdutos = input.nextInt();
						
                        if ((qtdVendProdutos > 0) && (qtdVendProdutos <= qtdEstoque)) {
                            lucroTotal += preco * qtdVendProdutos;
                            receitaTotal += preco * qtdVendProdutos;
                            qtdEstoque -= 1;
							
                            escreverProduto(codigo, preco, estoqueMax, custoRepo, qtdEstoque);
							
                            System.out.println("\nCompra efetuada com sucesso!");
                            Thread.sleep(1000);
                        }
                        else {
                            System.out.println("Quantidade de estoque insuficiente!");
                            Thread.sleep(1000);
                        }
                    }
                    else {
                        System.out.println("Estoque vazio!");
                        Thread.sleep(1000);
                    }
                }
                else {
                    System.out.println("Produto Inexistente!");
                    Thread.sleep(1000);
                }
                
                break;
            case 2:
                System.out.println("Aguarde...");
                Thread.sleep(1000);
                System.out.println("\n##############  Cadastro de Produto  ##############");
                
                System.out.println("\nCódigo: " + qtdProdutos+1);
                
                System.out.print("Preço Unitário: R$ ");
                preco = input.nextFloat();
                
                System.out.print("Quantidade de estoque máximo: ");
                estoqueMax = input.nextInt();
                
                System.out.print("Custo de reposição: R$ ");
                custoRepo = input.nextFloat();
                
                System.out.print("\nConfirmar cadastro de produto: ");
               
                desejo = input.nextLine().toLowerCase().charAt(0);
                
                while(desejo != 's' && desejo != 'n'){
                    Thread.sleep(1000);
                    System.out.print("Inválido!\n(S - sim) ou (N - não): ");
                    desejo = input.nextLine().toLowerCase().charAt(0);
                }
                
                if (desejo == 's') {
                    qtdProdutos += 1;
                    escreverProduto(qtdProdutos, preco, estoqueMax, custoRepo, 0);
					
                    System.out.println("Produto Cadastrado com Sucesso!");
                    Thread.sleep(1000);
                }
                
                break;
            case 3:
                System.out.println("Aguarde...");
                Thread.sleep(1000);
                System.out.println("##############   Banco de Dados  #############");
                
                if(qtdProdutos > 0){
                    codigo = 1;
                    while (codigo != 0) {                    
                        listaDeDados = lerProduto(codigo);

                        System.out.println("Código: " + codigo);
                        System.out.println("Preço: " + listaDeDados[0]);  //preço
                        System.out.println("Estoque Máximo: " + listaDeDados[1]);  //estoque máximo
                        System.out.println("Custo de Reposição: " + listaDeDados[2]);  //custo de reposição
                        System.out.println("Estoque disponível" + listaDeDados[3]);  //estoque
                    
                        System.out.println("A - anterior ");
                        System.out.println("P - próximo");
                        System.out.println("P - pesquisar por código");
                        System.out.println("S - sair");
                    
                        char op = Character.toLowerCase(input.next().charAt(0));

                        if(op == 'a' && codigo > 1){
                            codigo -= 1;
                        }
                        else if(op == 'p' && codigo < qtdProdutos){
                            codigo += 1;
                        }
                        else if (op == 'c') {
                            System.out.print("Código do produto: ");
                            codigo = input.nextInt();
                        
                            while(codigo < 1 || codigo > qtdProdutos){
                                System.out.println("Inválido!");
                                System.out.print("Código do produto: ");
                                codigo = input.nextInt();
                            }
                        } else{
                            System.out.println("Voltando ao menu...");
                            codigo = 0;
                        }
                    } //Fim do 'while'
                
                } else {
                    System.out.println("\nEstoque de produtos vazio!\n");
                    Thread.sleep(1000);
                }
                
                break;
            case 4:
                System.out.println("Aguarde...");
                Thread.sleep(1000);
                System.out.println("##############  Repor Estoque   #############");
                
                System.out.print("Código do produto: ");
                codigo = input.nextInt();
                
                while(codigo < 1 || codigo > qtdProdutos){
                    System.out.println("Inválido!");
                    System.out.println("Código do produto: ");
                    codigo = input.nextInt();
                }
                
                System.out.println("Repondo o estoque...");
                Thread.sleep(1000);
                
                listaDeDados = lerProduto(codigo);
                
                preco = listaDeDados[0];
                estoqueMax = listaDeDados[1];
                custoRepo = listaDeDados[2];
                qtdEstoque = listaDeDados[3];
                
                escreverProduto(codigo, preco, estoqueMax, custoRepo, estoqueMax);
                
                if(qtdEstoque > 0){
                    System.out.println((estoqueMax-qtdEstoque) + "produtos adicionados ao estoque");
                    Thread.sleep(1000);
                }else {
                    System.out.println("Estoque máximo reposto!");
                    Thread.sleep(1000);
                }
                
            case 5:
                System.out.println("Aguarde...");
                Thread.sleep(1000);
                System.out.println("##############  Relatório de Vendas   #############");
            
                break;
            case 6:
                System.out.println("Aguarde...");
                Thread.sleep(1000);
                System.out.println("##############  Relatório de Reposição   #############");
            
                break;
            case 7:
                System.out.println("Aguarde...");
                Thread.sleep(1000);
                System.out.println("##############  Status da Loja   #############");
                
                System.out.println("");
                System.out.println("Lucro Total: " + lucroTotal);
                System.out.println("Custo Total: " + custoTotal);
                System.out.println("Receita Total: " + receitaTotal);
                System.out.println("Quantidade de Produtos: " + qtdProdutos);
                
                System.out.println("'Enter' para continuar...");
                input.nextLine();
                
                break;
            case 8: 
            	System.out.print("Você tem certeza que deseja sair?\n(S - sim) ou (N - não): ");
                desejo = input.nextLine().toLowerCase().charAt(0);
                
                while(desejo != 's' && desejo != 'n'){
                    System.out.print("Opção Inválida!\n(S - sim) ou (N - não): ");
                    desejo = input.nextLine().toLowerCase().charAt(0);
                }
                if(desejo == 's'){
                    System.out.println("Saindo do Sistema...");
                    System.out.println("Atualizando o status da loja...");
                    Thread.sleep(1000);
                    
                  //variáveis para escrever no arquivo
                    fileWriter = new FileWriter(file);
                    filebuffW = new BufferedWriter(fileWriter);    
                    
                    filebuffW.write(Float.toString(lucroTotal) + '\n');
                    filebuffW.write(Float.toString(custoTotal) + '\n');
                    filebuffW.write(Float.toString(receitaTotal) + '\n');
                    filebuffW.write(Integer.toString(qtdProdutos) + '\n');
                    
                    filebuffW.close();
                }
                else{
                    System.out.println("Reiniciando Sistema...\n");
                    opcao = 0;
                }
                break;
            default:
                System.out.println("Inválido!\n\n");
                Thread.sleep(1000);
                
                break;
                
            } //End of Switch	
        } //End of While
    } //End of Main
} //End of Class

