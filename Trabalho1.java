import javax.swing.JOptionPane;
public class testetrab{
	public static void main(String[] args) {
		String nome,todosnomes,todascontas,todossaldos,rico;
		int operacao, i, j, conta,contarico,troca,a,fim;
		double saldo, transacao,maior,aux;
	
		//Uma 3x3 que armazene os nomes dos correntistas
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
	
		//Uma 3x3 que armazene os números das contas
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

		//Uma 3x3 que armazene os saldos respectivos
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
		
		//Menu(usando while e switch)
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

				//Inserir Recebimento 
				case 1:
					conta = Integer.parseInt(JOptionPane.showInputDialog("Insira o numero da conta"));
					transacao = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor a ser depositado"));
					for (i=0;i<3 ;i++ ) {
						for (j=0;j<3 ;j++ ) {
							if (B[i][j] == conta) {
								C[i][j] = C[i][j] + transacao;
								saldo = C[i][j];
								nome = A[i][j];
								JOptionPane.showMessageDialog(null,nome + " seu saldo atual é de: " + saldo);
								operacao = 0;
							}
						}
					}	
				break;
			
				//Inserir Pagamento 
				case 2:
					conta = Integer.parseInt(JOptionPane.showInputDialog("Insira o número da conta"));
					transacao = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor do pagamento"));
					for (i=0; i<3; i++) {
						for (j=0; j<3; j++) {
							if (B[i][j] == conta) {
								C[i][j] = C[i][j] - transacao;
								saldo = C[i][j];
								nome = A[i][j];
								JOptionPane.showMessageDialog(null, nome + " seu saldo atual é de: " + saldo);
								operacao=0;
							}
						}
					}
				break;
				
				//Números de Conta, Correntistas e Saldos respectivos
				case 3:
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
					JOptionPane.showMessageDialog(null,"Números das contas " + todascontas
						+"\n Nomes dos correntistas " + todosnomes
						+"\n Saldos das contas " + todossaldos);
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
								rico=rico+A[i][j];
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
					JOptionPane.showMessageDialog(null,"Os saldos ordenados do menor para o maior são: \n"+ vetorsaldo[0]
						+"\n"+vetorsaldo[1]
						+"\n"+vetorsaldo[2]
						+"\n"+vetorsaldo[3]
						+"\n"+vetorsaldo[4]
						+"\n"+vetorsaldo[5]
						+"\n"+vetorsaldo[6]
						+"\n"+vetorsaldo[7]
						+"\n"+vetorsaldo[8]);
					operacao = 0;
				break;

				case 6:
					operacao = 6;
				break;
			}
		}
	}
}
