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
	
	public static char desejoErro(char desejo){
		Scanner input = new Scanner(System.in);
		
		while(desejo != 's' && desejo != 'n'){
            System.out.print("Inválido!\n(S - sim) ou (N - não): ");
            desejo = Character.toLowerCase(input.next().charAt(0));
        }
		return desejo;
	}
//-------------##------------------##-----------------##--------------------##-----------------##---------------------##-----------------

    public static void escreverProduto(int codigo, String produto, float preco,int estoqueMax,float custoReposicao,int estoque) throws Exception{
        File file = new File("src/Sistema_Comercial/database/produtos/" + codigo);
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter filebuffW = new BufferedWriter(fileWriter);
        
        filebuffW.write( produto + '\n');
	    filebuffW.write( String.valueOf(preco) + '\n');
	    filebuffW.write( String.valueOf(estoqueMax) + '\n');
	    filebuffW.write( String.valueOf(custoReposicao) + '\n');
	    filebuffW.write( String.valueOf(estoque) + '\n');
	
	    filebuffW.close();
    }

//-------------##------------------##-----------------##--------------------##-----------------##---------------------##-----------------

    public static String[] lerProduto(int codigo) throws IOException{
        File file = new File("src/Sistema_Comercial/database/produtos/" + codigo);
        FileReader fileReader = new FileReader(file);
        BufferedReader filebuffR = new BufferedReader(fileReader);
        
        String[] listaDeValores = new String[5];
        
        listaDeValores[0] = filebuffR.readLine();    //produto
	    listaDeValores[1] = filebuffR.readLine();    //preço
	    listaDeValores[2] = filebuffR.readLine();    //estoque máximo
	    listaDeValores[3] = filebuffR.readLine();    //custo de reposição 
	    listaDeValores[4] = filebuffR.readLine();    //qtd. de estoque
        
       return listaDeValores;
    }

//-------------##------------------##-----------------##--------------------##-----------------##---------------------##-----------------
    
    public static void escreverLog(int codigo, String caminho, String produto, float preco,int estoqueMax,float custoReposicao,int estoque) throws Exception{
    	File file = new File("src/Sistema_Comercial/database/" + caminho + "/" + codigo);
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter filebuffW = new BufferedWriter(fileWriter);
        
        //variavel para data e hora
    	Calendar calendar = Calendar.getInstance();
    	
    	int ano, mes, dia, hora, minuto, segundo;
    	
		ano = calendar.get(Calendar.YEAR);
		mes = calendar.get(Calendar.MONTH);
		dia = calendar.get(Calendar.DAY_OF_MONTH);
		hora = calendar.get(Calendar.HOUR_OF_DAY);
		minuto = calendar.get(Calendar.MINUTE);
		segundo = calendar.get(Calendar.SECOND);
		
		filebuffW.write(dia + "/" + mes + "/" + ano);
		filebuffW.write(hora + ":" + minuto + ":" + segundo);
		filebuffW.write(produto);
		filebuffW.write( String.valueOf(preco));
		filebuffW.write( String.valueOf(estoqueMax));
		filebuffW.write( String.valueOf(custoReposicao));
		filebuffW.write( String.valueOf(estoque));
    	
    }
    
//-------------##------------------##-----------------##--------------------##-----------------##---------------------##-----------------

    public static String[] lerLog(int codigo, String caminho) throws Exception{
    	File file = new File("src/Sistema_Comercial/database/" + caminho + "/" + codigo);
        FileReader fileReader = new FileReader(file);
        BufferedReader filebuffR = new BufferedReader(fileReader);
        
        String[] listaDeValores = new String[5];
        
        listaDeValores[0] = filebuffR.readLine();
	    listaDeValores[1] = filebuffR.readLine();
	    listaDeValores[2] = filebuffR.readLine();
	    listaDeValores[3] = filebuffR.readLine();
	    listaDeValores[4] = filebuffR.readLine();
        
        
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
        String[] listaDeDados;  //recebe o retorno da função (lerProduto)
        
      //Variáveis para armazenar os dados de um produto
        String produto;
        float preco;      //preço
        int estoqueMax;   //estoque máximo
        float custoReposicao;  //custo de reposição
        int qtdEstoque;   //quantidade no estoque
                    
      //Abrindo o arquivo 'statusLoja.txt' para ler
        fileReader = new FileReader(file);
        filebuffR = new BufferedReader(fileReader);
      
      //Lendo o conteúdo do 'statusLoja.txt'
        float lucroTotal   = Float.parseFloat(filebuffR.readLine()); //recebendo lucroTotal
        float custoTotal   = Float.parseFloat(filebuffR.readLine()); //recebendo custoTotal
        float receitaTotal = Float.parseFloat(filebuffR.readLine()); //recebendo receitaTotal
        int qtdProdutos    = Integer.parseInt(filebuffR.readLine()); //recebendo qtdProdutos
        int qtdVendas      = Integer.parseInt(filebuffR.readLine()); //recebendo qtdVendas
        
        fileReader.close();
        
        System.out.println("##################################");
        System.out.println("#########  Loja Coding  ##########");
        System.out.println("##################################");
	
        while(opcao != 8)
        {
            System.out.println("\nMenu");
            System.out.println("1. Vender um Produto");
            System.out.println("2. Cadastrar um Produto");
            System.out.println("3. Consultar Banco de Dados");
            System.out.println("4. Repor Estoque");
            System.out.println("5. Verificar Relatório de Vendas");
            System.out.println("6. Verificar Relatório de Reposição");
            System.out.println("7. Status da Loja");
            System.out.println("8. Sair");
	
            System.out.print("\nComando: ");
            opcao = input.nextInt();
            input.nextLine();
            
        switch(opcao){
            case 1:
                System.out.println("Aguarde...");
                Thread.sleep(1000);   
                System.out.println("\n###########  Vender Produto  ###########");
                
                System.out.print("\nCódigo: ");
                codigo = input.nextInt();
                
                if(codigo > 0 && codigo <= qtdProdutos){
                    listaDeDados = lerProduto(codigo);
                    
                    produto = listaDeDados[0];
                    preco = Float.parseFloat(listaDeDados[1]);
                    estoqueMax = Integer.parseInt(listaDeDados[2]);
                    custoReposicao = Float.parseFloat(listaDeDados[3]);
                    qtdEstoque = Integer.parseInt(listaDeDados[4]);
                    
                    if (qtdEstoque > 0) {
                    	System.out.print("\nQuantos produtos deseja comprar: ");
                        int qtdVendProdutos = input.nextInt();
						
                        if ((qtdVendProdutos > 0) && (qtdVendProdutos <= qtdEstoque)) {
                            lucroTotal += preco * qtdVendProdutos;
                            receitaTotal += preco * qtdVendProdutos;
                            qtdEstoque--;
                            qtdVendas++;
							
                            escreverProduto(codigo, produto, preco, estoqueMax, custoReposicao, qtdEstoque);
							
                            System.out.println("\nQuantidade de produtos vendidos: " + qtdVendProdutos);
                            System.out.println("Preço da compra: " + preco*qtdVendProdutos);
                            System.out.println("Quantidade no estoque: " + qtdEstoque);
                            System.out.println("Quantidade de vendas:" + qtdVendas);
                            Thread.sleep(4000);
                            
                            System.out.println("\nCompra efetuada com sucesso!");
                            
                            //int codigo, String produto, float preco,int estoqueMax,float custoReposicao,int estoque
                            escreverLogVenda(qtdVendas, produto, preco, estoqueMax, custoReposicao, qtdEstoque);
                            
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
                
                System.out.println("\nCódigo: " + (qtdProdutos+1));
                
                System.out.print("Nome do produto: ");
                produto = input.nextLine();
                
                System.out.print("Preço Unitário: R$ ");
                preco = input.nextFloat();
                
                System.out.print("Quantidade de estoque máximo: ");
                estoqueMax = input.nextInt();
                
                System.out.print("Custo de reposição: R$ ");
                custoReposicao = input.nextFloat();
                
                System.out.print("\nConfirmar cadastro de produto?\n(S - sim) ou (N - não):");
               
                desejo = Character.toLowerCase(input.next().charAt(0));
                desejo = desejoErro(desejo);
                
                if (desejo == 's') {
                    qtdProdutos += 1;
                    //int codigo, float preco,int estoqueMax,float custoReposicao,int estoque
                    escreverProduto(qtdProdutos, produto, preco, estoqueMax, custoReposicao, 0);
					
                    System.out.println("\nProduto Cadastrado com Sucesso!");
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

                        System.out.println("\nCódigo: " + codigo);
                        System.out.println("Nome do produto: " + listaDeDados[0]); //produto
                        System.out.println("Preço: R$ " + listaDeDados[1]);  //preço
                        System.out.println("Estoque Máximo: " + listaDeDados[2]);  //estoque máximo
                        System.out.println("Custo de Reposição: R$ " + listaDeDados[3]);  //custo de reposição
                        System.out.println("Estoque disponível: " + listaDeDados[4]);  //estoque
                        System.out.println("\nAções: ");
                        System.out.println("A - Anterior ");
                        System.out.println("P - Próximo");
                        System.out.println("C - Pesquisar por código");
                        System.out.println("S - Sair");
                        
                        System.out.println("Comando: ");
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
                        
                            while(codigo < 1 || codigo >= qtdProdutos){
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
                
                if (qtdProdutos <= 0) {
                	System.out.println("\nEstoque de produtos vazio!\n");
                    Thread.sleep(1000);
					break;
				}
                System.out.print("\nCódigo do produto: ");
                codigo = input.nextInt();
                
                while(codigo < 1 || codigo > qtdProdutos){
                    System.out.println("\nInválido!");
                    System.out.println("Código do produto: ");
                    codigo = input.nextInt();
                }
                
                System.out.println("\nRepondo o estoque...");
                Thread.sleep(1000);
                
                listaDeDados = lerProduto(codigo);
                
                produto = listaDeDados[0];
                preco = Float.parseFloat(listaDeDados[1]);
                estoqueMax = Integer.parseInt(listaDeDados[2]);
                custoReposicao = Float.parseFloat(listaDeDados[3]);
                qtdEstoque = Integer.parseInt(listaDeDados[4]);
                
                escreverProduto(codigo, produto, preco, estoqueMax, custoReposicao, estoqueMax);
                
                if(qtdEstoque > 0){
                    System.out.println("\n" + (estoqueMax-qtdEstoque) + "produtos adicionados ao estoque");
                    Thread.sleep(1000);
                }else {
                    System.out.println("\nEstoque máximo reposto!");
                    Thread.sleep(1000);
                }
                break;
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
                Thread.sleep(4000);
                
                break;
            case 8: 
            	System.out.print("\nVocê tem certeza que deseja sair?\n(S - sim) ou (N - não): ");
                
            	desejo = Character.toLowerCase(input.next().charAt(0));
                desejo = desejoErro(desejo);
                
                if(desejo == 's'){
                    System.out.println("\nSaindo do Sistema...");
                    System.out.println("Atualizando o status da loja...");
                    Thread.sleep(1000);
                    
                  //variáveis para escrever no arquivo
                    fileWriter = new FileWriter(file);
                    filebuffW = new BufferedWriter(fileWriter);    
                    
                    filebuffW.write(Float.toString(lucroTotal) + '\n');
                    filebuffW.write(Float.toString(custoTotal) + '\n');
                    filebuffW.write(Float.toString(receitaTotal) + '\n');
                    filebuffW.write(Integer.toString(qtdProdutos) + '\n');
                    filebuffW.write(Integer.toString(qtdVendas) + '\n');
                    
                    filebuffW.close();
                }
                else{
                    System.out.println("Reiniciando Sistema...\n");
                    opcao = 0;
                }
                break;
            default:
                System.out.println("Inválido!\n");
                Thread.sleep(1000);
                
                break;
                
            } //End of Switch	
        } //End of While
    } //End of Main
} //End of Class
