package application;
	
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	public static Stage pStage;
	@Override
	public void start(Stage primaryStage) {
		try {
			pStage = primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
			pStage.setTitle("열람실 관리 프로그램");
			pStage.setScene(new Scene(root));
			pStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Timer tmer =new Timer();
		TimerTask t;
		t= new TimerTask()
		{
			@Override
			public void run()
			{
				String str1 = new java.text.SimpleDateFormat("HHmmss").format(new java.util.Date());
				for(int i=0;i<96;i++)
				{
					if(Controller.seatlist[i]!=0)
					{
						if(Integer.parseInt(Controller.time[i][1].substring(0,4))-Integer.parseInt(str1.substring(0,4))<1)
						{
							int tempT = Integer.parseInt(Controller.time[i][1].substring(0, 4))-Integer.parseInt(Controller.time[i][0].substring(0,4));
							if(tempT<0)
							{
								tempT = tempT +2400;
							}
							if(tempT<2)
							{
								for(int j=0;j<4096;j++)
								{
									if(Controller.userlist[j][0]==Controller.seatlist[i])
									{
										String s1 = new java.text.SimpleDateFormat("HHmmss").format(new java.util.Date());
										String s2 = new java.text.SimpleDateFormat("yyyyMMdd").format(new java.util.Date());
										if(Controller.userlist[j][1]==0)
										{
											Controller.userlist[j][1] = Controller.userlist[j][1]+1;
											Controller.userlist[j][2] = Integer.parseInt(s2.substring(2,8).concat(s1.substring(0,4)));
										}
										else
										{
											String str = String.valueOf(Controller.userlist[j][1]);
											if(str.length()==1)
											{
												Controller.userlist[j][3] = Integer.parseInt(s2.substring(2,8).concat(s1.substring(0,4)));
											}
											else if(str.length()==2)
											{
												Controller.userlist[j][4] = Integer.parseInt(s2.substring(2,8).concat(s1.substring(0,4)));
												Controller.userlist[j][5] = Integer.parseInt(s2) + 3;
											}
											String result = str.concat("1");
											Controller.userlist[j][1] = Integer.parseInt(result);
										}
									}
								}
								for(int k=0;k<50;k++)
								{
									int l = 0;
									if(Controller.inlist[k]==Controller.seatlist[i])
									{
										l = k;
										for(int m=k;m<49;m++)
										{
											Controller.inlist[m] = Controller.inlist[m+1];
										}
										if(l!=0||l>Controller.Incounter)
										{
											Controller.Incounter = Controller.Incounter - 1;
										}
									}
								}
							}
							Controller.seatlist[i] = 0;
							Controller.time[i][0] = null;
							Controller.time[i][1] = null;
							System.out.println("자동반납완료");
						}
					}
				}
			}
		};
		tmer.scheduleAtFixedRate(t, 0, 60000);
		launch(args);
	}
}
