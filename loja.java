
/*
*Importando os métodos de entrada,
*e de manipulação de arquivos
*/

//---------#---------#-----------
//*Importação de Métodos

import java.util.*;
import java.io.*;

/*
*---------#---------#---------#--------#--------#------////
*                   #LojaCoding
* @Daniel Santos, @Nykollas Regis, @João Vitor Silva
*---------#---------#---------#--------#--------#------////
*/

class Sistema_Comercial {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        File file = new File("src/Code/statusLoja.txt");
        FileWriter fileW = new FileWriter(file);
        BufferedWriter filebW = new BufferedWriter(fileW);
        FileReader fileR = new FileReader(file);
        BufferedReader filebR = new BufferedReader(fileR);
        
        int opcao = 0;
        
        System.out.println("##################################");
        System.out.println("######   Sistema Comercial  ######");
        System.out.println("##################################");
	
        while(opcao != 7)
        {
            System.out.println("Menu");
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

