/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monesystem;
import java.util.Scanner;
/**
 *
 * @author WIN8_USER
 */
public class BasicFunc {
    Personal prl = new Personal("Vivi",147852,100000); //宣告物件
	
    public void welCome(){
		System.out.println("WelCome to xxxATM ~~~"+"\n");
    }
	
    public void enterPass(){ //輸入密碼
		int check=0; //輸入密碼正確or超過3次
		for(int i=0;i<3;i++){ //輸入錯誤密碼3次,即離開程式
            System.out.println("Please enter your account password:");
            Scanner sc = new Scanner(System.in); //讀取輸入
            if(!prl.comparePasswd(sc.nextInt())){
				if(i<2){
					System.out.println("密碼輸入錯誤!!請重新輸入");
				}else{
                    check=1;
                    break;
				}
            }else{
				break;
            }
		}
		if(check==1){
            System.out.println("密碼輸入錯誤已達3次,卡片已鎖住,請洽服務人員協助");
            System.exit(0);
		}else{ 
            //進行系統操作
            doWork();
		}
    }
	
    public void doWork(){
		System.out.println("請選擇服務項目: 1)存款 2)提款 3)查詢帳戶資訊 4)離開:");
		Scanner op = new Scanner(System.in); //讀取輸入
		int option = op.nextInt();
		switch(option){
            case 1: //存款
				deposit();
				break;	
            case 2: //提款
				takeMoney();
				break;
            case 3: //查詢帳戶資訊
				printAccount();
				break;
            default:
				System.exit(0); //正常結束程式
				break;
		}	
    }
	
    public void deposit(){
		while(true){
            System.out.println("\n請輸入存款金額:");
            Scanner en = new Scanner(System.in); //讀取輸入
            int smon = en.nextInt();
            boolean save =  prl.saveMoney(smon);
            if(!save){
				System.out.println("請輸入正確存款金額!!");
            }else{
				break;
            }
		}
		System.out.println("\n是否繼續其他交易? 1)是 2)否");
		Scanner op = new Scanner(System.in); //讀取輸入
		int select = op.nextInt();
		if(select==1){
            doWork();
		}
    }
	
    public void takeMoney(){
		while(true){
            System.out.println("\n請輸入提款金額:");
            Scanner out = new Scanner(System.in); //讀取輸入
            int omon = out.nextInt();
            boolean take =  prl.countMoney(omon);
            if(!take){
				System.out.println("餘額不足!!");
            }else{
				break;
            }
		}
		System.out.println("\n是否繼續其他交易? 1)是 2)否");
		Scanner op = new Scanner(System.in); //讀取輸入
		int select = op.nextInt();
		if(select==1){
            doWork();
		}
    }
	
    public void printAccount(){
		prl.show();
		System.out.println("\n是否繼續其他交易? 1)是 2)否");
		Scanner op = new Scanner(System.in); //讀取輸入
		int select = op.nextInt();
		if(select==1){
            doWork();
		}
    }
}
