import javax.swing.JOptionPane;
import java.util.*;
public class testetrab2{
	static String nome,todosnomes,todascontas,todossaldos,rico,nome1;
	static int operacao, i, j, conta,contarico,troca,a,fim;
	static double saldo, transacao,maior,aux;
	
	static String A[][]=new String[3][3];
	static{
		A[0][0] = "Tibúrcio";
		A[0][1] = "Ricardo";
		A[0][2] = "João";
		A[1][0] = "Felisbino";
		A[1][1] = "Seu Zé";
		A[1][2] = "Dona Maria";
		A[2][0] = "Gedonstrôncio";
		A[2][1] = "Batman";
		A[2][2] = "Homem de Ferro";
	}
	static int B[][]=new int[3][3];
	static{
		B[0][0] = 111;
		B[0][1] = 222;
		B[0][2] = 333;
		B[1][0] = 444;
		B[1][1] = 555;
		B[1][2] = 666;
		B[2][0] = 777;
		B[2][1] = 888;
		B[2][2] = 999;
	}
	static double C[][]=new double[3][3];
	static{
		C[0][0]=0.0;
		C[0][1]=0.0;
		C[0][2]=0.0;
		C[1][0]=0.0;
		C[1][1]=0.0;
		C[1][2]=0.0;
		C[2][0]=0.0;
		C[2][1]=0.0;
		C[2][2]=0.0;
	}
	
	//Inserir Recebimento
	public static double Recebimento(int conta,double saldo){
		int i,j;
		for (i=0;i<3 ;i++ ) {
			for (j=0;j<3 ;j++ ) {
				if (B[i][j] == conta) {
					C[i][j] = C[i][j] + transacao;
					saldo = C[i][j];
					nome1= A[i][j];
				}
			}
		}return saldo;
	}
	//Inserir Pagamento 
	public static double Pagamento(int conta,double pagamento){
		for (i=0; i<3; i++) {
			for (j=0; j<3; j++) {
				if (B[i][j] == conta) {
					C[i][j] = C[i][j] - transacao;
					saldo = C[i][j];
					nome = A[i][j];
					operacao=0;
					return saldo;
				}
			}
		}return saldo;
	}
	//Números de Conta, Correntistas e Saldos respectivos
	public static void TodosNomesContasSaldos(){
		todosnomes="";
		todossaldos="";
		todascontas="";
		for (i=0;i<3 ;i++ ) {
			for (j=0;j<3 ;j++ ) {
				todosnomes=todosnomes + " : "+A[i][j];
				todascontas=todascontas+" : "+B[i][j];
				todossaldos=todossaldos+" : "+C[i][j];
				operacao = 0;
			}
		}
	}


	public static void main(String[] args) {
		
		String A[][]=new String[3][3];
		A[0][0] = "Tibúrcio";
		A[0][1] = "Ricardo";
		A[0][2] = "João";
		A[1][0] = "Felisbino";
		A[1][1] = "Seu Zé";
		A[1][2] = "Dona Maria";
		A[2][0] = "Gedonstrôncio";
		A[2][1] = "Batman";
		A[2][2] = "Homem de Ferro";
		
		int B[][]=new int[3][3];
		B[0][0] = 111;
		B[0][1] = 222;
		B[0][2] = 333;
		B[1][0] = 444;
		B[1][1] = 555;
		B[1][2] = 666;
		B[2][0] = 777;
		B[2][1] = 888;
		B[2][2] = 999;

		double C[][]=new double[3][3];
		C[0][0]=0.0;
		C[0][1]=0.0;
		C[0][2]=0.0;
		C[1][0]=0.0;
		C[1][1]=0.0;
		C[1][2]=0.0;
		C[2][0]=0.0;
		C[2][1]=0.0;
		C[2][2]=0.0;
		
		operacao = 0;
		
		while(operacao<=5){
			switch(operacao){
				case 0:
					operacao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma das operações abaixo: \n"
						+"1 - Inserir Recebimento \n"
						+"2 - Inserir Pagamento \n"
						+"3 - Todos os Números de Conta, Correntistas e Saldos respectivos \n"
						+"4 - O Número da Conta, o Nome do Correntista e o saldo do correntista mais RICO \n"
						+"5 - Os saldos ordenados do menor para o maior \n"
						+"6 - Sair"));
				break;
 
				case 1:
					conta = Integer.parseInt(JOptionPane.showInputDialog("Insira o numero da conta"));
					transacao = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor a ser depositado"));
					saldo=Recebimento(conta,transacao);
					JOptionPane.showMessageDialog(null,nome1 + " seu saldo atual é de: " + saldo);
					operacao = 0;
				break;
			
				case 2:
					conta = Integer.parseInt(JOptionPane.showInputDialog("Insira o número da conta"));
					transacao = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor do pagamento"));
					Pagamento(conta,transacao);
					JOptionPane.showMessageDialog(null, nome + " seu saldo atual é de: " + saldo);
				break;
				
				case 3:
					TodosNomesContasSaldos();
					JOptionPane.showMessageDialog(null,"Números das contas " + todascontas
						+"\nNomes dos correntistas " + todosnomes
						+"\nSaldos das contas " + todossaldos);
				break;
	
				// o Número da Conta, o Nome do Correntista e o saldo do correntista mais RICO
				case 4:
					contarico=0;
					maior=0;
					rico="";
					for (i=0;i<3 ;i++ ) {
						for (j=0;j<3;j++) {
							if (C[i][j]>maior) {
								maior=C[i][j];
								rico=A[i][j];
								contarico=B[i][j];
								operacao = 0;
							}
						}
					}JOptionPane.showMessageDialog(null," Numero da conta do correntista mais rico: "+contarico
						+"\n Em nome de: "+rico
						+"\n Com o saldo de: "+maior);
				break;

				// todos os saldos ordenados do menor para o maior usando BubbleSort.
				case 5:
					a=0;
					double vetorsaldo[]=new double[9];
					for (i=0;i<3 ;i++ ) {
						for (j=0;j<3 ;j++ ) {
							vetorsaldo[a]=C[i][j];
							a++;
						}
					}
					troca=1;
					fim=a-1;
					while(troca==1){
						troca = 0;
						for(i=0; i<fim;i++){
							if (vetorsaldo[i] > vetorsaldo[i+1]){
								aux = vetorsaldo[i];
								vetorsaldo[i] = vetorsaldo[i+1];
								vetorsaldo[i+1]=aux;
								troca = 1;
							}	
						}
					}                                             
					JOptionPane.showMessageDialog(null,"Os saldos ordenados do menor para o maior são: \n"+ Arrays.toString(vetorsaldo));
					operacao = 0;
				break;

				case 6:
					operacao = 6;
				break;
			}
		}
	}
}