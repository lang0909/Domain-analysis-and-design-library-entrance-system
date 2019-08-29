package application;

import java.io.IOException;
import java.util.Date;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller 
{
	static int Is_in = 0;
	static int Incounter = 0;
	static int Usercounter = 0;
	static long[][] userlist = new long[4096][6];
	static int[] inlist = new int[50];
	static int[] seatlist = new int[96];
	static String[][] time = new String[96][2];
	static int tempID = 0;
	static int floor = 0;
	static int count = 0;
	static Stage popupStage1;
	static Stage popupStage2;
	static Stage popupStage3;
	static Stage popupStage4;
	static Button[] bt = new Button[32];
	private static final Stage NULL = null;
	@FXML
	private TextField enterID;
	@FXML
	private TextField exitID;
	@FXML
	private TextField seatID;
	@FXML
	private TextField loginID;
	@FXML
	private TextField student_ID,delete_student_ID,penalty_student_ID,penaltyNumber;
	@FXML
	private PasswordField password;
	@FXML
	private TextField searchID;
	@FXML
	private TextArea d1_seatInfo,c1_seatInfo,b1_seatInfo;
	@FXML
	private TextArea penaltyDate1,penaltyDate2,penaltyDate3,penaltyDate4,penaltyTime1,penaltyTime2,penaltyTime3,penaltyForm1,penaltyForm2,penaltyForm3;
	@FXML
	private Button reserve,extend,retur;
	@FXML
	private Button D1,C1,B1;
	@FXML
	private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16;
	@FXML
	private Button btn17,btn18,btn19,btn20,btn21,btn22,btn23,btn24,btn25,btn26,btn27,btn28,btn29,btn30,btn31,btn32;
	
	@FXML
	private void S(ActionEvent event) throws Exception
	{
		Parent window1;
	    try {
	    	window1 = FXMLLoader.load(getClass().getResource("seatselect.fxml"));
	        Scene popupScene = new Scene(window1);
	        Stage popupStage = new Stage();
	        popupStage.setTitle("학번입력!!");
	        popupStage.setScene(popupScene);
	        popupStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	@FXML
	private void Et(ActionEvent event) throws Exception
	{
		Parent window2;
	    try {
	        window2 = FXMLLoader.load(getClass().getResource("enter.fxml"));
	        Scene popupScene = new Scene(window2);
	        Stage popupStage = new Stage();
	        popupStage.setTitle("Enter!!");
	        popupStage.setScene(popupScene);
	        popupStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	@FXML
	private void Ex(ActionEvent event) throws Exception
	{
		Parent window3;
	    try {
	    	window3 = FXMLLoader.load(getClass().getResource("exit.fxml"));
	        Scene popupScene = new Scene(window3);
	        Stage popupStage = new Stage();
	        popupStage.setTitle("Exit!!");
	        popupStage.setScene(popupScene);
	        popupStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	@FXML
	private void Mp(ActionEvent event) throws Exception
	{
		Parent window4;
	    try {
	    	window4 = FXMLLoader.load(getClass().getResource("login.fxml"));
	        Scene popupScene = new Scene(window4);
	        popupStage4 = new Stage();
	        popupStage4.setTitle("관리자시스템!!");
	        popupStage4.setScene(popupScene);
	        popupStage4.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	@FXML
	private void back(ActionEvent event) throws Exception
	{
		Parent window5;
		try {
	        window5 = FXMLLoader.load(getClass().getResource("menu.fxml"));
	        Stage window5Stage;
	        Scene window5Scene = new Scene(window5);
	        window5Stage = Main.pStage;
	        window5Stage.setTitle("열람실관리프로그램!!!");
	        window5Stage.setScene(window5Scene);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	@FXML
	private void extend(ActionEvent event)
	{
		for(int i=0;i<96;i++)
		{
			if(seatlist[i]==tempID)
			{
				time[i][1] = addTime(new java.text.SimpleDateFormat("HHmmss").format(new java.util.Date()),4);
			}
		}
		StackPane stackPane = new StackPane(new Label("연장되었습니다!!!"));
		Scene popupScene = new Scene(stackPane,100,100);
		Stage popupStage = new Stage();
		popupStage.setScene(popupScene);
		popupStage.show();
		
		PauseTransition wait = new PauseTransition(Duration.seconds(1));
		wait.setOnFinished((e)->{
			popupStage.close();
			wait.playFromStart();
		});
		wait.play();
		popupStage1.close();
		return;
	}
	
	@FXML
	private void retur(ActionEvent event)
	{
		for(int i=0;i<96;i++)
		{
			if(seatlist[i]==tempID)
			{
				seatlist[i] = 0;
				time[i][0] = null;
				time[i][1] = null;
			}
		}
		StackPane stackPane = new StackPane(new Label("반납되었습니다!!!"));
		Scene popupScene = new Scene(stackPane,100,100);
		Stage popupStage = new Stage();
		popupStage.setScene(popupScene);
		popupStage.show();
		
		PauseTransition wait = new PauseTransition(Duration.seconds(1));
		wait.setOnFinished((e)->{
			popupStage.close();
			wait.playFromStart();
		});
		wait.play();
		popupStage1.close();
		return;
	}
	
	@FXML
	private void Login(ActionEvent event) throws Exception
	{
		Parent window10;
		String s1 = loginID.getText();
		String s2 = password.getText();
		if(s1.equals("lang0909") && s2.equals("123123"))
		{
			try {
		        window10 = FXMLLoader.load(getClass().getResource("managermenu.fxml"));
		        Scene window10Scene = new Scene(window10);
		        Stage window10Stage = new Stage();
		        window10Stage.setTitle("열람실관리프로그램!!!");
		        window10Stage.setScene(window10Scene);
		        window10Stage.show();
		        popupStage4.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
			return;
		}
		else
		{
			StackPane stackPane = new StackPane(new Label("ID나 비밀번호를 다시 입력해주세요!!!"));
			Scene popupScene = new Scene(stackPane,500,100);
			Stage popupStage = new Stage();
			popupStage.setScene(popupScene);
			popupStage.show();
			
			PauseTransition wait = new PauseTransition(Duration.seconds(1));
			wait.setOnFinished((e)->{
				popupStage.close();
				wait.playFromStart();
			});
			wait.play();
			return;
		}
	}
	
	@FXML
	private synchronized void Register(ActionEvent event) throws Exception
	{
		String s3 = student_ID.getText();
		if(s3.length()!=9)
		{
			StackPane stackPane = new StackPane(new Label("ID는 숫자 9자리입니다!!!"));
			Scene popupScene = new Scene(stackPane,500,100);
			Stage popupStage = new Stage();
			popupStage.setScene(popupScene);
			popupStage.show();
			
			PauseTransition wait = new PauseTransition(Duration.seconds(1));
			wait.setOnFinished((e)->{
				popupStage.close();
				wait.playFromStart();
			});
			wait.play();
			return;
		}
		else
		{
			char[] chs = s3.toCharArray();
			for(int i=0;i<9;i++)
			{
				if(chs[i]<48 || chs[i]>57)
				{
					StackPane stackPane = new StackPane(new Label("ID에는 숫자만 들어갑니다!!!"));
					Scene popupScene = new Scene(stackPane,500,100);
					Stage popupStage = new Stage();
					popupStage.setScene(popupScene);
					popupStage.show();
					
					PauseTransition wait = new PauseTransition(Duration.seconds(1));
					wait.setOnFinished((e)->{
						popupStage.close();
						wait.playFromStart();
					});
					wait.play();
					return;
				}
			}
		}
		for(int i=0;i<4096;i++)
		{
			if(userlist[i][0]==0)
			{
				Usercounter = i;
				break;
			}
		}
		userlist[Usercounter][0] = Integer.parseInt(s3);
		StackPane stackPane = new StackPane(new Label("등록되었습니다!!!"));
		Scene popupScene = new Scene(stackPane,100,100);
		Stage popupStage = new Stage();
		popupStage.setScene(popupScene);
		popupStage.show();
		
		PauseTransition wait = new PauseTransition(Duration.seconds(1));
		wait.setOnFinished((e)->{
			popupStage.close();
			wait.playFromStart();
		});
		wait.play();
	}
	
	@FXML
	private void SRegister(ActionEvent event) throws Exception
	{
		Parent window11;
		try {
	        window11 = FXMLLoader.load(getClass().getResource("register.fxml"));
	        Scene popupScene = new Scene(window11);
	        Stage popupStage = new Stage();
	        popupStage.setTitle("유저등록!!!");
	        popupStage.setScene(popupScene);
	        popupStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	@FXML
	private synchronized void Delete(ActionEvent event) throws Exception
	{
		String s4 = delete_student_ID.getText();
		if(s4.length()!=9)
		{
			StackPane stackPane = new StackPane(new Label("ID는 숫자 9자리입니다!!!"));
			Scene popupScene = new Scene(stackPane,500,100);
			Stage popupStage = new Stage();
			popupStage.setScene(popupScene);
			popupStage.show();
			
			PauseTransition wait = new PauseTransition(Duration.seconds(1));
			wait.setOnFinished((e)->{
				popupStage.close();
				wait.playFromStart();
			});
			wait.play();
			return;
		}
		else
		{
			char[] chs = s4.toCharArray();
			for(int i=0;i<9;i++)
			{
				if(chs[i]<48 || chs[i]>57)
				{
					StackPane stackPane = new StackPane(new Label("ID에는 숫자만 들어갑니다!!!"));
					Scene popupScene = new Scene(stackPane,500,100);
					Stage popupStage = new Stage();
					popupStage.setScene(popupScene);
					popupStage.show();
					
					PauseTransition wait = new PauseTransition(Duration.seconds(1));
					wait.setOnFinished((e)->{
						popupStage.close();
						wait.playFromStart();
					});
					wait.play();
					return;
				}
			}
		}
		int temp1 = 0;
		int temp2 = 0;
		for(int i=0;i<4096;i++)
		{
			if(userlist[i][0]==0)
			{
				temp1 = i;
				break;
			}
		}
		for(int i=0;i<4096;i++)
		{
			if(userlist[i][0]==Integer.parseInt(s4))
			{
				temp2 = i;
				break;
			}
		}
		for(int i=0;i<50;i++)
		{
			if(inlist[i]==Integer.parseInt(s4))
			{
				int j = i;
				for(int k=j;k<49;k++)
				{
					inlist[k] = inlist[k+1];
				}
				if(j!=0||j>Incounter)
				{
					Incounter = Incounter - 1;
				}
			}
		}
		for(int i=0;i<96;i++)
		{
			if(seatlist[i]==Integer.parseInt(s4))
			{
				seatlist[i] = 0;
				time[i][0] = null;
				time[i][1] = null;
			}
		}
		for(int i=temp2;i<=temp1;i++)
		{
			userlist[i][0] = userlist[i+1][0];
			userlist[i][1] = userlist[i+1][1];
			userlist[i][2] = userlist[i+1][2];
			userlist[i][3] = userlist[i+1][3];
			userlist[i][4] = userlist[i+1][4];
			userlist[i][5] = userlist[i+1][5];
		}
		StackPane stackPane = new StackPane(new Label("삭제되었습니다!!!"));
		Scene popupScene = new Scene(stackPane,100,100);
		Stage popupStage = new Stage();
		popupStage.setScene(popupScene);
		popupStage.show();
		
		PauseTransition wait = new PauseTransition(Duration.seconds(1));
		wait.setOnFinished((e)->{
			popupStage.close();
			wait.playFromStart();
		});
		wait.play();
	}
	
	@FXML
	private void SDelete(ActionEvent event) throws Exception
	{
		Parent window12;
		try {
	        window12 = FXMLLoader.load(getClass().getResource("delete.fxml"));
	        Scene popupScene = new Scene(window12);
	        Stage popupStage = new Stage();
	        popupStage.setTitle("유저삭제!!!");
	        popupStage.setScene(popupScene);
	        popupStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	@FXML
	private void Show(ActionEvent event) throws Exception
	{
		Parent window13;
		try {
	        window13 = FXMLLoader.load(getClass().getResource("search.fxml"));
	        Scene popupScene = new Scene(window13);
	        Stage popupStage = new Stage();
	        popupStage.setTitle("유저검색!!!");
	        popupStage.setScene(popupScene);
	        popupStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	@FXML
	private synchronized void Pdelete(ActionEvent event) throws Exception
	{
		String s1 = penalty_student_ID.getText();
		String s2 = penaltyNumber.getText();
		for(int i=0;i<4096;i++)
		{
			if(userlist[i][0]==Integer.parseInt(s1))
			{
				if(userlist[i][1]==0)
				{
					StackPane stackPane = new StackPane(new Label("패널티가 없습니다!!!"));
					Scene popupScene = new Scene(stackPane,500,100);
					Stage popupStage = new Stage();
					popupStage.setScene(popupScene);
					popupStage.show();
					
					PauseTransition wait = new PauseTransition(Duration.seconds(1));
					wait.setOnFinished((e)->{
						popupStage.close();
						wait.playFromStart();
					});
					wait.play();
					return;
				}
				if(Integer.parseInt(s2)==0)
				{
					StackPane stackPane = new StackPane(new Label("패널티횟수를 0이상으로 입력해주세요!!!"));
					Scene popupScene = new Scene(stackPane,500,100);
					Stage popupStage = new Stage();
					popupStage.setScene(popupScene);
					popupStage.show();
					
					PauseTransition wait = new PauseTransition(Duration.seconds(1));
					wait.setOnFinished((e)->{
						popupStage.close();
						wait.playFromStart();
					});
					wait.play();
					return;
				}
				if(String.valueOf(userlist[i][1]).length() < Integer.parseInt(s2))
				{
					StackPane stackPane = new StackPane(new Label("받은 패널티수보다 많습니다!!!"));
					Scene popupScene = new Scene(stackPane,500,100);
					Stage popupStage = new Stage();
					popupStage.setScene(popupScene);
					popupStage.show();
					
					PauseTransition wait = new PauseTransition(Duration.seconds(1));
					wait.setOnFinished((e)->{
						popupStage.close();
						wait.playFromStart();
					});
					wait.play();
					return;
				}
				else
				{
					if(String.valueOf(userlist[i][1]).length() == Integer.parseInt(s2))
					{
						userlist[i][1] = 0;
						userlist[i][2] = 0;
						userlist[i][3] = 0;
						userlist[i][4] = 0;
						userlist[i][5] = 0;
					}
					else
					{
						int y = (String.valueOf(userlist[i][1]).length()-Integer.parseInt(s2));
						userlist[i][1] = Integer.parseInt(String.valueOf(userlist[i][1]).substring(0,y));
						for(int j=0;j<Integer.parseInt(s2);j++)
						{
							userlist[i][4-j] = 0;
						}
						userlist[i][5] = 0;
					}
					StackPane stackPane = new StackPane(new Label("패널티가 삭제되었습니다!!!"));
					Scene popupScene = new Scene(stackPane,500,100);
					Stage popupStage = new Stage();
					popupStage.setScene(popupScene);
					popupStage.show();
					
					PauseTransition wait = new PauseTransition(Duration.seconds(1));
					wait.setOnFinished((e)->{
						popupStage.close();
						wait.playFromStart();
					});
					wait.play();
					return;
				}
			}
		}
	}
	
	@FXML
	private void PDelete(ActionEvent event) throws Exception
	{
		Parent window13;
		try {
	        window13 = FXMLLoader.load(getClass().getResource("pdelete.fxml"));
	        Scene popupScene = new Scene(window13);
	        Stage popupStage = new Stage();
	        popupStage.setTitle("패널티삭제!!!!");
	        popupStage.setScene(popupScene);
	        popupStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	
	@FXML
	private synchronized void Search(ActionEvent event) throws Exception
	{
		String s1 = searchID.getText();
		Parent window15;
		try 
	    {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("result.fxml"));
			window15 = loader.load();
			Controller controller = loader.getController();
			for(int i=0;i<4096;i++)
			{
				if(userlist[i][0] == Integer.parseInt(s1))
				{
					if(userlist[i][1]==0)
					{
						break;
					}
					else
					{
						char ch[] = String.valueOf(userlist[i][1]).toCharArray();
						String da1,da2,da3,da4,t1,t2,t3;
						if(String.valueOf(userlist[i][1]).length()==1)
						{
							da1 = String.valueOf(userlist[i][2]).substring(0,2).concat("/").concat(String.valueOf(userlist[i][2]).substring(2,4)).concat("/").concat(String.valueOf(userlist[i][2]).substring(4,6));
							t1 = String.valueOf(userlist[i][2]).substring(6,8).concat(":").concat(String.valueOf(userlist[i][2]).substring(8,10));
							controller.penaltyDate1.setText("\n\n        "+da1);
							controller.penaltyTime1.setText("\n\n        "+t1);
							if(userlist[i][1]==1)
							{
								controller.penaltyForm1.setText("\n\n        좌석자동반납!!");
							}
							else
							{
								controller.penaltyForm1.setText("\n\n        중복입장!!");
							}
							break;
						}
						if(String.valueOf(userlist[i][1]).length()==2)
						{
							da1 = String.valueOf(userlist[i][2]).substring(0,2).concat("/").concat(String.valueOf(userlist[i][2]).substring(2,4)).concat("/").concat(String.valueOf(userlist[i][2]).substring(4,6));
							t1 = String.valueOf(userlist[i][2]).substring(6,8).concat(":").concat(String.valueOf(userlist[i][2]).substring(8,10));
							da2 = String.valueOf(userlist[i][3]).substring(0,2).concat("/").concat(String.valueOf(userlist[i][3]).substring(2,4)).concat("/").concat(String.valueOf(userlist[i][3]).substring(4,6));
							t2 = String.valueOf(userlist[i][3]).substring(6,8).concat(":").concat(String.valueOf(userlist[i][3]).substring(8,10));
							controller.penaltyDate1.setText("\n\n        "+da1);
							controller.penaltyDate2.setText("\n\n        "+da2);
							controller.penaltyTime1.setText("\n\n        "+t1);
							controller.penaltyTime2.setText("\n\n        "+t2);
							if(ch[0]=='1')
							{
								controller.penaltyForm1.setText("\n\n        좌석자동반납!!");
							}
							else
							{
								controller.penaltyForm1.setText("\n\n        중복입장!!");
							}
							if(ch[1]=='1')
							{
								controller.penaltyForm2.setText("\n\n        좌석자동반납!!");
							}
							else
							{
								controller.penaltyForm2.setText("\n\n        중복입장!!");
							}
							break;
						}
						if(String.valueOf(userlist[i][1]).length()==3)
						{
							da1 = String.valueOf(userlist[i][2]).substring(0,2).concat("/").concat(String.valueOf(userlist[i][2]).substring(2,4)).concat("/").concat(String.valueOf(userlist[i][2]).substring(4,6));
							t1 = String.valueOf(userlist[i][2]).substring(6,8).concat(":").concat(String.valueOf(userlist[i][2]).substring(8,10));
							da2 = String.valueOf(userlist[i][3]).substring(0,2).concat("/").concat(String.valueOf(userlist[i][3]).substring(2,4)).concat("/").concat(String.valueOf(userlist[i][3]).substring(4,6));
							t2 = String.valueOf(userlist[i][3]).substring(6,8).concat(":").concat(String.valueOf(userlist[i][3]).substring(8,10));
							da3 = String.valueOf(userlist[i][4]).substring(0,2).concat("/").concat(String.valueOf(userlist[i][4]).substring(2,4)).concat("/").concat(String.valueOf(userlist[i][4]).substring(4,6));
							t3 = String.valueOf(userlist[i][4]).substring(6,8).concat(":").concat(String.valueOf(userlist[i][4]).substring(8,10));
							da4 = String.valueOf(userlist[i][5]).substring(0,4).concat("/").concat(String.valueOf(userlist[i][5]).substring(4,6)).concat("/").concat(String.valueOf(userlist[i][5]).substring(6,8));
							controller.penaltyDate1.setText("\n\n        "+da1);
							controller.penaltyDate2.setText("\n\n        "+da2);
							controller.penaltyDate3.setText("\n\n        "+da3);
							controller.penaltyDate4.setText("\n\n        "+da4);
							controller.penaltyTime1.setText("\n\n        "+t1);
							controller.penaltyTime2.setText("\n\n        "+t2);
							controller.penaltyTime3.setText("\n\n        "+t3);
							if(ch[0]=='1')
							{
								controller.penaltyForm1.setText("\n\n        좌석자동반납!!");
							}
							else
							{
								controller.penaltyForm1.setText("\n\n        중복입장!!");
							}
							if(ch[1]=='1')
							{
								controller.penaltyForm2.setText("\n\n        좌석자동반납!!");
							}
							else
							{
								controller.penaltyForm2.setText("\n\n        중복입장!!");
							}
							if(ch[2]=='1')
							{
								controller.penaltyForm3.setText("\n\n        좌석자동반납!!");
							}
							else
							{
								controller.penaltyForm3.setText("\n\n        중복입장!!");
							}
							break;
						}
					}
				}
				if(i==4095)
				{
					StackPane stackPane = new StackPane(new Label("등록되지않은 사람입니다!!!"));
					Scene popupScene = new Scene(stackPane,500,100);
					Stage popupStage = new Stage();
					popupStage.setScene(popupScene);
					popupStage.show();
					
					PauseTransition wait = new PauseTransition(Duration.seconds(1));
					wait.setOnFinished((e)->{
						popupStage.close();
						wait.playFromStart();
					});
					wait.play();
					return;
				}
			}
	        Scene popupScene2 = new Scene(window15);
	        Stage popupStage = new Stage();
	        popupStage.setTitle("Penalty show!!");
	        popupStage.setScene(popupScene2);
	        popupStage.show();
		}
	    catch (IOException e) 
	    {
	        e.printStackTrace();
	    }
		return;
	}
	
	@FXML
	private synchronized void Enter(ActionEvent event) throws Exception
	{
		String foo = enterID.getText();
		if(foo.length()!=9)
		{
			StackPane stackPane = new StackPane(new Label("ID는 숫자 9자리입니다!!!"));
			Scene popupScene = new Scene(stackPane,500,100);
			Stage popupStage = new Stage();
			popupStage.setScene(popupScene);
			popupStage.show();
			
			PauseTransition wait = new PauseTransition(Duration.seconds(1));
			wait.setOnFinished((e)->{
				popupStage.close();
				wait.playFromStart();
			});
			wait.play();
			return;
		}
		else
		{
			char[] chs = foo.toCharArray();
			for(int i=0;i<9;i++)
			{
				if(chs[i]<48 || chs[i]>57)
				{
					StackPane stackPane = new StackPane(new Label("ID에는 숫자만 들어갑니다!!!"));
					Scene popupScene = new Scene(stackPane,500,100);
					Stage popupStage = new Stage();
					popupStage.setScene(popupScene);
					popupStage.show();
					
					PauseTransition wait = new PauseTransition(Duration.seconds(1));
					wait.setOnFinished((e)->{
						popupStage.close();
						wait.playFromStart();
					});
					wait.play();
					return;
				}
			}
		}
		for(int i=0;i<50;i++)
		{
			if(inlist[i]==Integer.parseInt(foo))
			{
				for(int j=0;j<4096;j++)
				{
					if(userlist[j][0]==Integer.parseInt(foo))
					{
						String s1 = new java.text.SimpleDateFormat("HHmmss").format(new java.util.Date());
						String s2 = new java.text.SimpleDateFormat("yyyyMMdd").format(new java.util.Date());
						if(userlist[j][1]==0)
						{
							userlist[j][1] = userlist[j][1] +2;
							//userlist[j][2] = Integer.parseInt(s2.substring(2,8).concat(addTime(s1,10).substring(0,4)));
							userlist[j][2] = Integer.parseInt(s2.substring(2,8).concat(s1.substring(0,4)));
						}
						else
						{
							String str = String.valueOf(userlist[j][1]);
							if(str.length()==1)
							{
								userlist[j][3] = Integer.parseInt(s2.substring(2,8).concat(s1.substring(0,4)));
							}
							else if(str.length()==2)
							{
								userlist[j][4] = Integer.parseInt(s2.substring(2,8).concat(s1.substring(0,4)));
								userlist[j][5] = Integer.parseInt(s2)+3;
							}
							else
							{
								StackPane stackPane = new StackPane(new Label("penalty초과로 제재되었습니다!!!"));
								Scene popupScene = new Scene(stackPane,500,100);
								Stage popupStage = new Stage();
								popupStage.setScene(popupScene);
								popupStage.show();
								
								PauseTransition wait = new PauseTransition(Duration.seconds(1));
								wait.setOnFinished((e)->{
									popupStage.close();
									wait.playFromStart();
								});
								wait.play();
								return;
							}
							String result = str.concat("2");
							userlist[j][1] = Integer.parseInt(result);
						}
					}
				}
				StackPane stackPane = new StackPane(new Label("중복입장입니다!!!"));
				Scene popupScene = new Scene(stackPane,100,100);
				Stage popupStage = new Stage();
				popupStage.setScene(popupScene);
				popupStage.show();
				
				PauseTransition wait = new PauseTransition(Duration.seconds(1));
				wait.setOnFinished((e)->{
					popupStage.close();
					wait.playFromStart();
				});
				wait.play();
				return;
			}
		}
		for(int i=0;i<96;i++)
		{
			if(seatlist[i]==Integer.parseInt(foo))
			{
				time[i][1] = addTime(time[i][0],4);
			}
		}
		for(int i=0;i<4096;i++)
		{
			if(userlist[i][0]==Integer.parseInt(foo))
			{
				if(userlist[i][1]>100)
				{
					StackPane stackPane = new StackPane(new Label("penalty초과로 제재되었습니다!!!"));
					Scene popupScene = new Scene(stackPane,500,100);
					Stage popupStage = new Stage();
					popupStage.setScene(popupScene);
					popupStage.show();
					
					PauseTransition wait = new PauseTransition(Duration.seconds(1));
					wait.setOnFinished((e)->{
						popupStage.close();
						wait.playFromStart();
					});
					wait.play();
					return;
				}
				else
				{
					inlist[Incounter++] = Integer.parseInt(foo);
					StackPane stackPane = new StackPane(new Label("어서오십시오!!!"));
					Scene popupScene = new Scene(stackPane,100,100);
					Stage popupStage = new Stage();
					popupStage.setScene(popupScene);
					popupStage.show();
					
					PauseTransition wait = new PauseTransition(Duration.seconds(1));
					wait.setOnFinished((e)->{
						popupStage.close();
						wait.playFromStart();
					});
					wait.play();
					return;
				}
			}
		}
		StackPane stackPane = new StackPane(new Label("등록되지 않은 사람입니다!!!"));
		Scene popupScene = new Scene(stackPane,500,100);
		Stage popupStage = new Stage();
		popupStage.setScene(popupScene);
		popupStage.show();
		
		PauseTransition wait = new PauseTransition(Duration.seconds(1));
		wait.setOnFinished((e)->{
			popupStage.close();
			wait.playFromStart();
		});
		wait.play();
		return;
	}
	
	@FXML
	private synchronized void Exit(ActionEvent event) throws Exception
	{
		int j=0;
		String foo1 = exitID.getText();
		if(foo1.length()!=9)
		{
			StackPane stackPane = new StackPane(new Label("ID는 숫자9자리 입니다!!!"));
			Scene popupScene = new Scene(stackPane,500,100);
			Stage popupStage = new Stage();
			popupStage.setScene(popupScene);
			popupStage.show();
			
			PauseTransition wait = new PauseTransition(Duration.seconds(1));
			wait.setOnFinished((e)->{
				popupStage.close();
				wait.playFromStart();
			});
			wait.play();
			return;
		}
		else
		{
			char[] chs = foo1.toCharArray();
			for(int i=0;i<9;i++)
			{
				if(chs[i]<48 || chs[i]>57)
				{
					StackPane stackPane = new StackPane(new Label("ID에는 숫자만 들어갑니다!!!"));
					Scene popupScene = new Scene(stackPane,500,100);
					Stage popupStage = new Stage();
					popupStage.setScene(popupScene);
					popupStage.show();
					
					PauseTransition wait = new PauseTransition(Duration.seconds(1));
					wait.setOnFinished((e)->{
						popupStage.close();
						wait.playFromStart();
					});
					wait.play();
					return;
				}
			}
		}
		for(int i=0;i<96;i++)
		{
			if(seatlist[i]==Integer.parseInt(foo1))
			{
				time[i][1] = addTime(time[i][0],1);
				System.out.println(time[i][0]);
				System.out.println(time[i][1]);
			}
		}
		for(int i=0;i<50;i++)
		{
			if(inlist[i]==Integer.parseInt(foo1))
			{
				j = i;
				for(int k=j;k<49;k++)
				{
					inlist[k] = inlist[k+1];
				}
				if(j!=0||j>Incounter)
				{
					Incounter = Incounter - 1;
				}
				StackPane stackPane = new StackPane(new Label("안녕히가십시오!!!"));
				Scene popupScene = new Scene(stackPane,100,100);
				Stage popupStage = new Stage();
				popupStage.setScene(popupScene);
				popupStage.show();
				
				PauseTransition wait1 = new PauseTransition(Duration.seconds(1));
				wait1.setOnFinished((e)->{
					popupStage.close();
					wait1.playFromStart();
				});
				wait1.play();
				return;
			}
		}
		StackPane stackPane = new StackPane(new Label("도서관에 들어오지 않은 사람입니다!!!"));
		Scene popupScene = new Scene(stackPane,300,100);
		Stage popupStage = new Stage();
		popupStage.setScene(popupScene);
		popupStage.show();
		
		PauseTransition wait = new PauseTransition(Duration.seconds(1));
		wait.setOnFinished((e)->{
			popupStage.close();
			wait.playFromStart();
		});
		wait.play();
		return;
	}
	
	@FXML
	private synchronized void seatselect(ActionEvent event) throws Exception
	{
		tempID = Integer.parseInt(seatID.getText());
		if(seatID.getText().length()!=9)
		{
			StackPane stackPane = new StackPane(new Label("ID는 숫자 9자리 입니다!!!"));
			Scene popupScene = new Scene(stackPane,500,100);
			Stage popupStage = new Stage();
			popupStage.setScene(popupScene);
			popupStage.show();
			
			PauseTransition wait = new PauseTransition(Duration.seconds(1));
			wait.setOnFinished((e)->{
				popupStage.close();
				wait.playFromStart();
			});
			wait.play();
			return;
		}
		else
		{
			char[] chs = seatID.getText().toCharArray();
			for(int i=0;i<9;i++)
			{
				if(chs[i]<48 || chs[i]>57)
				{
					StackPane stackPane = new StackPane(new Label("ID에는 숫자만 들어갑니다!!!"));
					Scene popupScene = new Scene(stackPane,500,100);
					Stage popupStage = new Stage();
					popupStage.setScene(popupScene);
					popupStage.show();
					
					PauseTransition wait = new PauseTransition(Duration.seconds(1));
					wait.setOnFinished((e)->{
						popupStage.close();
						wait.playFromStart();
					});
					wait.play();
					return;
				}
			}
		}
		String ptr = "\n\n\n  ";
		String ptr2 = "/32";
		Parent window7;
		for(int i=0;i<96;i++)
		{
			if(seatlist[i]==tempID)
			{
				if((Integer.parseInt(time[i][1].substring(0, 4))-Integer.parseInt(new java.text.SimpleDateFormat("HHmmss").format(new java.util.Date()).substring(0,4)))<200)
				{
					try
				    {
						FXMLLoader loader = new FXMLLoader();
						loader.setLocation(getClass().getResource("selection.fxml"));
						window7 = loader.load();
						Controller controller = loader.getController();
						controller.reserve.setDisable(true);
						Scene popupScene1 = new Scene(window7);
				        popupStage1 = new Stage();
				        popupStage1.setTitle("Selection!!");
				        popupStage1.setScene(popupScene1);
				        popupStage1.show();
					}
				    catch (IOException e) 
				    {
				        e.printStackTrace();
				    }
					return;
				}
				else
				{
					try
				    {
						FXMLLoader loader = new FXMLLoader();
						loader.setLocation(getClass().getResource("selection.fxml"));
						window7 = loader.load();
						Controller controller = loader.getController();
						controller.reserve.setDisable(true);
						controller.extend.setDisable(true);
						Scene popupScene1 = new Scene(window7);
				        popupStage1 = new Stage();
				        popupStage1.setTitle("Selection!!");
				        popupStage1.setScene(popupScene1);
				        popupStage1.show();
					}
				    catch (IOException e) 
				    {
				        e.printStackTrace();
				    }
					return;
				}
			}
		}
		for(int i=0;i<50;i++)
		{
			if(inlist[i]==tempID)
			{
				Is_in = 1;
			}
		}
		if(Is_in!=1)
		{
			StackPane stackPane = new StackPane(new Label("도서관에 들어오지 않은 사람입니다!!!"));
			Scene popupScene = new Scene(stackPane,300,100);
			Stage popupStage = new Stage();
			popupStage.setScene(popupScene);
			popupStage.show();
			
			PauseTransition wait = new PauseTransition(Duration.seconds(1));
			wait.setOnFinished((e)->{
				popupStage.close();
				wait.playFromStart();
			});
			wait.play();
			return;
		}
		else
		{
			Is_in=0;
		}
		try 
	    {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("roominfo.fxml"));
			window7 = loader.load();
			Controller controller = loader.getController();
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<32;j++)
				{
					if(seatlist[i*32+j]==0)
					{
						count++;
					}
				}
				if(i==0)
				{
					String ptr1 = String.valueOf(count);
					controller.b1_seatInfo.setText(ptr.concat(ptr1).concat(ptr2));
				}
				if(i==1)
				{
					String ptr1 = String.valueOf(count);
					controller.c1_seatInfo.setText(ptr.concat(ptr1).concat(ptr2));
				}
				if(i==2)
				{
					String ptr1 = String.valueOf(count);
					controller.d1_seatInfo.setText(ptr.concat(ptr1).concat(ptr2));
				}
				count=0;
			}
	        Scene popupScene2 = new Scene(window7);
	        popupStage2 = new Stage();
	        popupStage2.setTitle("RoomInfo!!");
	        popupStage2.setScene(popupScene2);
	        popupStage2.show();
		}
	    catch (IOException e) 
	    {
	        e.printStackTrace();
	    }
		return;
	}
	
	private String addTime(String a,int x)
	{
		String temp1 = a.substring(0,4);
		temp1 = String.valueOf(Integer.parseInt(temp1)+x);
		return temp1.concat(a.substring(4));
		/*String temp = a.substring(0,2);
		if(Integer.parseInt(temp)+x<24)
		{
			temp = String.valueOf(Integer.parseInt(temp)+x);
			return temp.concat(a.substring(2));
		}
		else
		{
			temp = String.valueOf((Integer.parseInt(temp)+x)%24);
			temp = temp.format("%02d", 2);
			return temp.concat(a.substring(2));
		}*/
	}
	
	@FXML
	private synchronized void D(ActionEvent event) throws Exception
	{
		bt[0] = btn1; bt[1] = btn2; bt[2]= btn3; bt[3] = btn4; bt[4]=btn5; bt[5]=btn6;
		bt[6] = btn7; bt[7] = btn8; bt[8]= btn9; bt[9] = btn10; bt[10] = btn11; bt[11]= btn12;
		bt[12] = btn13; bt[13] = btn14; bt[14]= btn15; bt[15] = btn16; bt[16] = btn17; bt[17]= btn18;
		bt[18] = btn19; bt[19] = btn20; bt[20]= btn21; bt[21] = btn22; bt[22] = btn23; bt[23]= btn24;
		bt[24] = btn25; bt[25] = btn26; bt[26]= btn27; bt[27] = btn28; bt[28] = btn29; bt[29]= btn30;
		bt[30] = btn31; bt[31] = btn32;
		Parent window6;
		String str = ((Button)event.getSource()).getText();
		if(str.equals("B1") || str.equals("C1") || str.equals("D1"))
		{
			if(str.equals("B1"))
			{
				floor=0;
			}
			else if(str.equals("C1"))
			{
				floor=1;
			}
			else if(str.equals("D1"))
			{
				floor=2;
			}
			try 
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("seat.fxml"));
				window6 = loader.load();
				Controller controller1 = loader.getController();
				for(int i=0;i<32;i++)
				{
					if(seatlist[i+floor*32]!=0)
					{
						switch(i)
						{
						case 0:
							controller1.btn1.setDisable(true);
							break;
						case 1:
							controller1.btn2.setDisable(true);
							break;
						case 2:
							controller1.btn3.setDisable(true);
							break;
						case 3:
							controller1.btn4.setDisable(true);
							break;
						case 4:
							controller1.btn5.setDisable(true);
							break;
						case 5:
							controller1.btn6.setDisable(true);
							break;
						case 6:
							controller1.btn7.setDisable(true);
							break;
						case 7:
							controller1.btn8.setDisable(true);
							break;
						case 8:
							controller1.btn9.setDisable(true);
							break;
						case 9:
							controller1.btn10.setDisable(true);
							break;
						case 10:
							controller1.btn11.setDisable(true);
							break;
						case 11:
							controller1.btn12.setDisable(true);
							break;
						case 12:
							controller1.btn13.setDisable(true);
							break;
						case 13:
							controller1.btn14.setDisable(true);
							break;
						case 14:
							controller1.btn15.setDisable(true);
							break;
						case 15:
							controller1.btn16.setDisable(true);
							break;
						case 16:
							controller1.btn17.setDisable(true);
							break;
						case 17:
							controller1.btn18.setDisable(true);
							break;
						case 18:
							controller1.btn19.setDisable(true);
							break;
						case 19:
							controller1.btn20.setDisable(true);
							break;
						case 20:
							controller1.btn21.setDisable(true);
							break;
						case 21:
							controller1.btn22.setDisable(true);
							break;
						case 22:
							controller1.btn23.setDisable(true);
							break;
						case 23:
							controller1.btn24.setDisable(true);
							break;
						case 24:
							controller1.btn25.setDisable(true);
							break;
						case 25:
							controller1.btn26.setDisable(true);
							break;
						case 26:
							controller1.btn27.setDisable(true);
							break;
						case 27:
							controller1.btn28.setDisable(true);
							break;
						case 28:
							controller1.btn29.setDisable(true);
							break;
						case 29:
							controller1.btn30.setDisable(true);
							break;
						case 30:
							controller1.btn31.setDisable(true);
							break;
						case 31:
							controller1.btn32.setDisable(true);
							break;
						}
					}
				}
			Scene popupScene = new Scene(window6);
			popupStage3 = new Stage();
		    popupStage3.setTitle("SeatInfo!!");
		    popupStage3.setScene(popupScene);
		    popupStage3.show();
		    } 
			catch (IOException e)
			{
		        e.printStackTrace();
		    }
		}
		else
		{
			seatlist[Integer.parseInt(str)-1+32*floor] = tempID;
			time[Integer.parseInt(str)-1+32*floor][0] = new java.text.SimpleDateFormat("HHmmss").format(new java.util.Date());
			time[Integer.parseInt(str)-1+32*floor][1] = addTime(time[Integer.parseInt(str)-1+32*floor][0],4);
			System.out.println(time[Integer.parseInt(str)-1+32*floor][0]);
			System.out.println(time[Integer.parseInt(str)-1+32*floor][1]);
			bt[Integer.parseInt(str)%33-1].setDisable(true);
			popupStage2.close();
			StackPane stackPane = new StackPane(new Label("좌석예약이 완료되었습니다!!!"));
			Scene popupScene = new Scene(stackPane,300,100);
			Stage popupStage = new Stage();
			popupStage.setScene(popupScene);
			popupStage.show();
			PauseTransition wait = new PauseTransition(Duration.seconds(1));
			wait.setOnFinished((e)->{
				popupStage.close();
				wait.playFromStart();
			});
			wait.play();
			popupStage3.close();
			return;
		}
	}
}
