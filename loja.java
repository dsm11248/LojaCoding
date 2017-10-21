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
        File file = new File("src//Sistema_Comercial//statusLoja.txt"); //abrindo o statusLoja.txt
        
      //variáveis para ler o arquivo
        FileReader fileReader = new FileReader(file);    BufferedReader filebuffR = new BufferedReader(fileReader);
        
        int opcao = 0; 
        
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
                //os.system()
                System.out.println("###########  Vender Produto  ###########");
                
                System.out.print("\nCódigo: ");
                int codigo = input.nextInt();
                
                if(codigo > 0 && codigo < qtdProdutos){
                	int[] listaDados = lerProduto(codigo);
                    
                	float preco = listaDados[0];
                    int estoqueMax = listaDados[1];
                    float custoRepo = listaDados[2];
                    int qtdEstoque = listaDados[3];
                    
                    if (qtdEstoque > 0) {
                    	System.out.print("Quantos produtos deseja comprar: ");
						int qtdVendProdutos = input.nextInt();
						
						if ((qtdVendProdutos > 0) && (qtdVendProdutos <= qtdEstoque)) {
							lucroTotal += preco * qtdVendProdutos;
							receitaTotal += preco * qtdVendProdutos;
							qtdEstoque -= 1;
							
							escreverProduto(codigo,preco,estoqueMax,custoRepo,qtdEstoque);
							
							System.out.println("\nCompra efetuada com sucesso!");
						}
						else {
							
						}
					}
                    else {
						System.out.println("Quantidade de estoque insuficiente!");
					}
                }
                else {
					System.out.println("Produto Inexistente!");
				}
                
                break;
            case 2:
                System.out.println("Aguarde...");
                Thread.sleep(1000);
                System.out.println("##############  Cadastro de Produto  ##############");
            
                break;
            case 3:
                System.out.println("Aguarde...");
                Thread.sleep(1000);
                System.out.println("##############   Banco de Dados  #############");
            
                break;
            case 4:
                System.out.println("Aguarde...");
                Thread.sleep(1000);
                System.out.println("##############  Relatório de Vendas   #############");
            
                break;
            case 5:
                System.out.println("Aguarde...");
                Thread.sleep(1000);
                System.out.println("##############  Relatório de Reposição   #############");
            
                break;
            case 6:
                System.out.println("Aguarde...");
                Thread.sleep(1000);
                System.out.println("##############  Status da Loja   #############");
                
            
                break;
            case 7: 
		System.out.println("Você tem certeza que deseja sair?");
                System.out.print("(S - sim) ou (N - não): ");
                char confirm = input.next().charAt(0);
                confirm = Character.toLowerCase(confirm);
                
                while(confirm != 's' && confirm != 'n'){
                    System.out.println("Opção Inválida!");
                    System.out.print("(S - sim) ou (N - não): ");
                    confirm = input.next().charAt(0);
                    confirm = Character.toLowerCase(confirm);
                }
                if(confirm == 's'){
                    System.out.println("Saindo do Sistema...");
                    System.out.println("Atualizando o status da loja...");
                    Thread.sleep(1000);
                    
                    //variáveis para escrever no arquivo
                    FileWriter fileWriter = new FileWriter(file);    BufferedWriter filebuffW = new BufferedWriter(fileWriter);    
                    
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
                System.out.println("Opção Inválida!!!\n\n");
                
            } //End of Switch	
        } //End of While
    } //End of Main
} //End of Class


