import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.TextField;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import javax.swing.JDialog;
import javax.swing.JFileChooser;

import processing.core.PApplet;

@SuppressWarnings("unused")
public class ReadApplet extends PApplet {

	// $FF: renamed from: a java.io.File
	private static File field_0;
	// $FF: renamed from: a java.io.FileWriter
	private static FileWriter field_1;
	// $FF: renamed from: a java.io.PrintWriter
	private static PrintWriter field_2;
	// $FF: renamed from: a boolean
	private static boolean field_3;
	// $FF: renamed from: a java.awt.Button
	private static Button field_4;
	// $FF: renamed from: a javax.swing.JFileChooser
	private static JFileChooser field_5;
	// $FF: renamed from: a long
	private static long field_6;
	// $FF: renamed from: a java.awt.Label[]
	private static Label[] field_7;
	// $FF: renamed from: b java.awt.Label[]
	private static Label[] field_8;
	// $FF: renamed from: c java.awt.Label[]
	private static Label[] field_9;
	// $FF: renamed from: a java.awt.Label[][]
	private static Label[][] field_10;
	// $FF: renamed from: b java.awt.Label[][]
	private static Label[][] field_11;
	// $FF: renamed from: a java.awt.Label
	private static Label field_12;
	// $FF: renamed from: b java.awt.Label
	private static Label field_13;
	// $FF: renamed from: c java.awt.Label
	private static Label field_14;
	// $FF: renamed from: a java.awt.TextField
	private static TextField field_15;
	// $FF: renamed from: d java.awt.Label
	private static Label field_16;
	// $FF: renamed from: e java.awt.Label
	private static Label field_17;
	// $FF: renamed from: f java.awt.Label
	private static Label field_18;
	// $FF: renamed from: g java.awt.Label
	private static Label field_19;
	// $FF: renamed from: a int
	private static int field_20;
	// $FF: renamed from: a java.lang.String
	private static String field_21;
	// $FF: renamed from: a java.lang.String[]
	private static String[] field_22;
	// $FF: renamed from: a int[]
	private static int[] field_23;
	// $FF: renamed from: b int
	private static int field_24;
	// $FF: renamed from: c int
	private static int field_25;
	// $FF: renamed from: d int
	private static int field_26;
	// $FF: renamed from: e int
	private static int field_27;
	// $FF: renamed from: a java.lang.Thread
	private static Thread field_28 = new Thread();
	// $FF: renamed from: a java.net.Socket
	private static Socket field_29;
	// $FF: renamed from: b java.io.PrintWriter
	private static PrintWriter field_30;
	// $FF: renamed from: a java.io.BufferedInputStream
	private static BufferedInputStream field_31;
	//String for inputs (var7)
	private static String inputs;
	static String outString;
	static String updated;


	// $FF: renamed from: <init> () void
	//	public readforjar() {
	//		super();
	//		this.field_0 = null;
	//		this.field_4 = new Button("Data Logging: INACTIVE");
	//		this.field_6 = 0L;
	//		this.field_7 = new Label[8];
	//		this.field_8 = new Label[8];
	//		this.field_9 = new Label[8];
	//		this.field_10 = new Label[8][2];
	//		this.field_11 = new Label[8][2];
	//		this.field_12 = new Label("Name");
	//		this.field_13 = new Label("ID");
	//		this.field_14 = new Label("Sequence");
	//		this.field_15 = new TextField();
	//		this.field_16 = new Label("seconds", 1);
	//		this.field_17 = new Label("Update", 1);
	//		this.field_18 = new Label("Channel 1", 1);
	//		this.field_19 = new Label("Channel 2", 1);
	//		this.field_22 = new String[8];
	//		this.field_23 = new int[8];
	//		this.field_24 = 1;
	//		this.field_25 = 5;
	//		this.field_26 = 0;
	//		this.field_27 = 0;
	//		this.field_28 = null;
	//		this.field_29 = null;
	//		this.field_30 = null;
	//		this.field_31 = null;
	//	}
	//
	//	public void init() {
	//		this.setLayout((LayoutManager)null);
	//		this.setBackground(Color.white);
	//		this.setSize(550, 380);
	//		this.field_12.setAlignment(1);
	//		this.field_12.setFont(new Font("Dialog", 0, 13));
	//		this.field_12.setBounds(15, 10, 67, 20);
	//		this.add(this.field_12);
	//		this.field_13.setAlignment(1);
	//		this.field_13.setFont(new Font("Dialog", 0, 13));
	//		this.field_13.setBounds(100, 10, 33, 20);
	//		this.add(this.field_13);
	//		this.field_14.setAlignment(1);
	//		this.field_14.setFont(new Font("Dialog", 0, 13));
	//		this.field_14.setBounds(145, 10, 67, 20);
	//		this.add(this.field_14);
	//		this.add(this.field_18);
	//		this.field_18.setForeground(Color.black);
	//		this.field_18.setFont(new Font("Dialog", 1, 13));
	//		this.field_18.setBounds(230, 10, 87, 20);
	//		this.add(this.field_19);
	//		this.field_19.setForeground(Color.black);
	//		this.field_19.setFont(new Font("Dialog", 1, 13));
	//		this.field_19.setBounds(380, 10, 87, 20);
	//
	//		for(int var1 = 0; var1 < 8; ++var1) {
	//			this.field_7[var1] = new Label();
	//			this.field_7[var1].setText("--");
	//			this.field_7[var1].setAlignment(1);
	//			this.field_7[var1].setFont(new Font("Dialog", 1, 13));
	//			this.field_7[var1].setBounds(10, 40 + var1 * 30, 80, 20);
	//			this.add(this.field_7[var1]);
	//			this.field_8[var1] = new Label();
	//			this.field_8[var1].setText("-");
	//			this.field_8[var1].setAlignment(1);
	//			this.field_8[var1].setForeground(Color.black);
	//			this.field_8[var1].setFont(new Font("Dialog", 1, 13));
	//			this.field_8[var1].setBounds(100, 40 + var1 * 30, 33, 20);
	//			this.add(this.field_8[var1]);
	//			this.field_9[var1] = new Label();
	//			this.field_9[var1].setText("-");
	//			this.field_9[var1].setAlignment(1);
	//			this.field_9[var1].setForeground(Color.black);
	//			this.field_9[var1].setFont(new Font("Dialog", 1, 13));
	//			this.field_9[var1].setBounds(140, 40 + var1 * 30, 80, 20);
	//			this.add(this.field_9[var1]);
	//
	//			for(int var2 = 0; var2 < 2; ++var2) {
	//				this.field_10[var1][var2] = new Label();
	//				this.field_10[var1][var2].setText("--");
	//				this.field_10[var1][var2].setAlignment(1);
	//				this.field_10[var1][var2].setBackground(new Color(176, 196, 222));
	//				this.field_10[var1][var2].setForeground(Color.white);
	//				this.field_10[var1][var2].setFont(new Font("Dialog", 1, 20));
	//				this.field_10[var1][var2].setBounds(230 + var2 * 150, 40 + var1 * 30, 87, 20);
	//				this.add(this.field_10[var1][var2]);
	//				this.field_11[var1][var2] = new Label();
	//				this.field_11[var1][var2].setText("--");
	//				this.field_11[var1][var2].setFont(new Font("Dialog", 1, 12));
	//				this.field_11[var1][var2].setBounds(320 + var2 * 150, 40 + var1 * 30, 60, 20);
	//				this.add(this.field_11[var1][var2]);
	//			}
	//
	//			this.field_22[var1] = new String("--");
	//			this.field_23[var1] = 0;
	//		}
	//
	//		this.add(this.field_4);
	//		this.field_4.setFont(new Font("Dialog", 1, 10));
	//		this.field_4.setBackground(Color.lightGray);
	//		this.field_4.setBounds(150, 310, 140, 25);
	//		this.add(this.field_17);
	//		this.field_17.setForeground(Color.black);
	//		this.field_17.setFont(new Font("Dialog", 1, 10));
	//		this.field_17.setBounds(150, 345, 40, 20);
	//		this.field_15.setText(Integer.toString(this.field_25));
	//		this.add(this.field_15);
	//		this.field_15.setForeground(Color.black);
	//		this.field_15.setFont(new Font("Dialog", 1, 10));
	//		this.field_15.setBounds(206, 345, 38, 20);
	//		this.add(this.field_16);
	//		this.field_16.setForeground(Color.black);
	//		this.field_16.setFont(new Font("Dialog", 1, 10));
	//		this.field_16.setBounds(250, 345, 48, 20);
	//		this.field_3 = false;
	//		this.field_6 = 0L;
	//		this.field_25 = 5;
	//		this.field_26 = 0;
	//	}
	//
	public static void main(String[] args) {
		field_20 = 'A' - 65 << 3;

		//			for(int var1 = 0; var1 < 8; ++var1) {
		//				field_8[var1].setText(Integer.toString(field_20 + var1));
		//			}

		if((field_20 >> 3) + 1 >= 10) {
			field_21 = "0" + Integer.toString(((field_20 >> 3) + 1) / 10) + "0";
		} else {
			field_21 = "00" + (char)((field_20 >> 3) + 65);
		}
		PApplet.main("ReadApplet");
		//			if(this.field_28 == null) {
		//				this.field_28 = new Thread(this);
		//				this.field_28.start();
		//			}

	}
	//
	//	public void stop() {
	//		if(this.field_28 != null) {
	//			this.field_28 = null;
	//		}
	//
	//		if(this.field_29 != null) {
	//			try {
	//				this.field_29.close();
	//				return;
	//			} catch (Exception var2) {
	//				System.err.println("R" + this.field_20 + ": Error Closing Socket: " + var2);
	//			}
	//		}
	//
	//	}

	public static void read() {
		for(int i = 0; i < 100; i++){
			int var20;
			//System.setOut(System.err);
			//while(field_28 != null) {
			if(field_29 == null) {
				try {
					field_29 = new Socket("10.3.3.33", 1001);
					field_30 = new PrintWriter(field_29.getOutputStream(), true);
					field_31 = new BufferedInputStream(field_29.getInputStream());
				} catch (UnknownHostException var15) {
					System.err.println("R" + field_20 + ": Don\'t know about host: iServer.");
					System.exit(-1);
				} catch (IOException var16) {
					System.err.println("R" + field_20 + ": Couldn\'t get connection - " + var16);
					System.exit(-1);
				}
			}

			int var1 = 0;
			String var2 = new String("?");

			try {
				field_27 = 0;

				while(field_27 < 30) {
					if(field_27 % 5 == 0) {
						if(field_24 == 1) {
							field_30.println("EQNG" + field_21);
						} else {
							field_30.println("ERDG" + field_21);
						}
					}

					try {
						Thread.sleep(33000L);
					} catch (InterruptedException var14) {
						var14.printStackTrace();
					}

					byte[] var3 = new byte[4096];
					boolean var4 = false;
					if((var20 = field_31.available()) > 0) {
						//System.out.println("data in");
						if(field_31.read(var3, 0, var20) != 0) {
							//System.out.println(var3[0]);
							if(var3[0] != 79 && var3[0] != 69 && var3[0] != 87 && var3[0] != 84) {
								var2 = new String(var3, 0, var20);
								StringTokenizer var18 = new StringTokenizer(var2, "\r\n");
								if(field_3 && field_24 == 0) {
									field_2.print(new Date() + ",");
								}

								while(var18.hasMoreTokens()) {
									String var7 = var18.nextToken();
									//System.out.println(var7);
									StringTokenizer var6 = new StringTokenizer(var7, " ");

									inputs = var7;
									//System.out.println(inputs);

									int var5 = 0;

									String[] var8;
									for(var8 = new String[11]; var6.hasMoreTokens(); var8[var5++] = var6.nextToken()) {
										;
									}

									if(var5 >= 3) {
										int var21;
										if((var21 = Integer.parseInt(var8[0])) < field_20 || var21 >= field_20 + 8) {
											continue;
										}

										if(field_24 == 1) {
											field_26 = 1;
											field_22[var21 & 7] = var7.substring(var8[0].length() + 1, var7.indexOf(var8[var5 - 2]) - 1);
											if(var8[var5 - 2].charAt(0) == 49) {
												field_23[var21 & 7] = 1;
											} else if(var8[var5 - 2].charAt(1) == 49) {
												field_23[var21 & 7] = 2;
											} else if(var8[var5 - 2].charAt(2) == 49) {
												field_23[var21 & 7] = 3;
											} else {
												field_23[var21 & 7] = 0;
											}

											++var1;
											System.exit(-1);
										}

										if(var5 < 3) {
											continue;
										}

										//										field_7[var1].setText(field_22[var21 & 7]);
										//										field_7[var1].setVisible(true);
										//										field_8[var1].setVisible(true);
										//										//										field_8[var1].setText(var8[0]);
										//										if(field_23[var21 & 7] != 0) {
										//											if(field_23[var21 & 7] == 2) {
										////												var8[1] = "Lost";
										//											} else if(field_23[var21 & 7] == 3) {
										////												var8[1] = "ID";
										//											}
										//
										//											//											field_9[var1].setVisible(true);
										//										}

										//										field_9[var1].setText(var8[1]);
										//										field_9[var1].setVisible(true);
										if(field_3 && field_24 == 0) {
											field_2.print(var8[0] + "," + var8[1] + "," + var8[2] + ",");
										}

										var21 = Integer.parseInt(var8[2]);
										int var22 = 0;
										if(var5 > 3) {
											for(int var9 = 3; var9 < var5; ++var22) {
												if(var21 == 25) {
													//													field_10[var1][1].setVisible(false);
													//													field_11[var1][1].setVisible(false);
												} else if(var21 == 26) {
													var22 = 1;
													//													field_10[var1][0].setVisible(false);
													//													field_11[var1][0].setVisible(false);
												}

												//												field_10[var1][var22].setVisible(true);
												//												field_11[var1][var22].setVisible(true);
												//												field_10[var1][var22].setText(var8[var9]);
												//												field_11[var1][var22].setText(var8[var9 + 1]);
												Color var10;
												switch(var22) {
												case 0:
													var10 = Color.red;
													break;
												default:
													var10 = new Color(0, 153, 0);
												}

												//												field_10[var1][var22].setForeground(var10);
												//												field_11[var1][var22].setForeground(var10);
												if(field_3 && field_24 == 0) {
													field_2.print(var8[var9] + "," + var8[var9 + 1] + ",");
												}

												var9 += 2;
											}
										}

										++var1;
									}

									if(var1 == 8) {
										break;
									}
								}

								if(field_3 && field_24 == 0) {
									field_2.print("\n");
									field_2.flush();
								}

								field_6 = (field_6 + 1L) % Long.MAX_VALUE;
							}

							field_27 = 100;
						}
					} else if(var20 == 0) {
						++field_27;
					} else {
						field_27 = 50;
					}
				}

				if(field_25 > 100 || field_27 == 30 && field_29 != null) {
					try {
						System.err.println(new Date() + " R" + field_20 + " nodata; port:" + field_29.getLocalPort());
						field_29.close();
					} catch (Exception var13) {
						System.err.println("R" + field_20 + ": Error Closing Socket: " + var13);
					}

					field_29 = null;
				}

				int var19;
				for(var19 = var1; var19 < 8; ++var19) {
					//					field_7[var19].setVisible(false);
					//					field_8[var19].setVisible(false);
					//					field_9[var19].setVisible(false);

					for(var20 = 0; var20 < 2; ++var20) {
						//						field_10[var19][var20].setVisible(false);
						//						field_11[var19][var20].setVisible(false);
					}
				}

				if(field_24 == 0 && field_6 % 20L == 0L) {
					field_24 = 1;
					field_26 = 0;
				} else if(field_24 == 0) {
					try {
						for(var19 = 0; var19 < field_25; ++var19) {
							Thread.sleep(1000L);
						}
					} catch (InterruptedException var11) {
						;
					}
				} else if(field_24 == 1 && field_26 == 1) {
					field_24 = 0;

					try {
						for(var19 = 0; var19 < field_25; ++var19) {
							Thread.sleep(1000L);
						}
					} catch (InterruptedException var12) {
						;
					}
				}
			} catch (IOException var17) {
				System.err.println("R" + field_20 + ": Error reading socket: " + var17 + "--" + var2);
				var17.printStackTrace();
			}

			if(inputs != null){     
				double level = 0;
				String[] inputsStr = inputs.split(" ");
				level = Double.parseDouble(inputsStr[3]);
				outString = "Level: " + level + " in";
				Date now = new Date();
				SimpleDateFormat dform = new SimpleDateFormat("hh:mm:ss a");
				updated = dform.format(now);
				System.out.println(outString);
				//				try{
				//					String pass = new Password().password;
				//					String address = "http://cademons.org/river/write.php";
				//					Date dconn = new Date();
				//					SimpleDateFormat dform = new SimpleDateFormat("yyyy.MM.dd.HH");
				//					String date = dform.format(dconn);
				//					String data = date +"," + level;
				//					System.out.println(data);
				//					URL url = new URL(address + "?authcode=" + pass + "&data=" + data);
				//					System.out.println(url);
				//					HttpURLConnection request = (HttpURLConnection)url.openConnection();
				//					request.setRequestMethod("GET");
				//					request.connect();
				//					System.out.println(request.getResponseCode());
				//					BufferedReader in = new BufferedReader(new InputStreamReader(
				//							request.getInputStream()));
				//					String inputLine;
				//					while ((inputLine = in.readLine()) != null) 
				//						System.out.println(inputLine);
				//					in.close();
				//				} catch (IOException e) {
				//					e.printStackTrace();
				//				}
			}
			//	}
		}
	}

	public void setup(){
		size(300, 200);
		textSize(14);
		fill(0);
		Thread t = new Thread(new Runnable(){
			public void run() {
				read();
			}
		});
		t.start();
	}

	public void draw(){
		background(255);
		if(outString != null){
			text(outString, 50, 80);
			text("Updated: " + updated, 50, 100);
		}else{
			text("Waiting for data", 50, 80);
		}
	}

	//	public boolean action(Event var1, Object var2) {
	//		if(var1.target instanceof Button) {
	//			if(var2.toString().substring(0, 12).compareTo("Data Logging") == 0) {
	//				JDialog var4;
	//				if(!this.field_3) {
	//					this.field_5 = new JFileChooser();
	//					if(this.field_5.showSaveDialog(this) == 0) {
	//						if(this.field_0 != null) {
	//							this.field_2.close();
	//						}
	//
	//						if(this.field_5.getSelectedFile().getName().lastIndexOf(46) == -1) {
	//							this.field_5.setSelectedFile(new File(this.field_5.getSelectedFile().getAbsoluteFile() + ".csv"));
	//						} else if(!this.field_5.getSelectedFile().getName().endsWith(".csv")) {
	//							(var4 = new JDialog()).setTitle("Save Current Graph");
	//							var4.add(new Label("File Type Error: file must be saved in TEXT format(.csv)"));
	//							var4.resize(330, 80);
	//							var4.show();
	//						}
	//
	//						if(this.field_5.getSelectedFile().getName().endsWith(".csv")) {
	//							this.field_0 = this.field_5.getSelectedFile();
	//
	//							try {
	//								this.field_1 = new FileWriter(this.field_0);
	//								this.field_2 = new PrintWriter(this.field_1);
	//							} catch (IOException var3) {
	//								System.err.println("R" + this.field_20 + ": IOException:");
	//								var3.printStackTrace();
	//								return false;
	//							}
	//
	//							this.field_3 = true;
	//							this.field_4.setLabel("Data Logging: ACTIVE");
	//							this.field_6 = 0L;
	//							(var4 = new JDialog()).setTitle("Data Logging");
	//							var4.setLayout(new FlowLayout());
	//							var4.add(new Label("Data logging in " + this.field_0));
	//							var4.resize(500, 80);
	//							var4.show();
	//						}
	//					} else {
	//						(var4 = new JDialog()).setTitle("Data Logging");
	//						var4.setLayout(new FlowLayout());
	//						var4.add(new Label("Data logging inactivated"));
	//						var4.resize(230, 80);
	//						var4.show();
	//					}
	//				} else {
	//					this.field_3 = false;
	//					this.field_4.setLabel("Data Logging: INACTIVE");
	//					if(this.field_2 != null) {
	//						this.field_2.close();
	//					}
	//
	//					this.field_0 = null;
	//					(var4 = new JDialog()).setTitle("Data Logging");
	//					var4.setLayout(new FlowLayout());
	//					var4.add(new Label("Data logging inactivated"));
	//					var4.resize(230, 80);
	//					var4.show();
	//				}
	//			}
	//		} else if(var1.target == this.field_15) {
	//			this.field_25 = Integer.parseInt(this.field_15.getText());
	//			if(this.field_25 < 1) {
	//				this.field_25 = 1;
	//			} else if(this.field_25 > 86400) {
	//				this.field_25 = 86400;
	//			}
	//
	//			this.field_15.setText(Integer.toString(this.field_25));
	//			return true;
	//		}
	//
	//		return true;
	//	}
}
