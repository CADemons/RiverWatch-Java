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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

public class read extends Applet implements Runnable {

	// $FF: renamed from: a java.io.File
	private File field_0;
	// $FF: renamed from: a java.io.FileWriter
	private FileWriter field_1;
	// $FF: renamed from: a java.io.PrintWriter
	private PrintWriter field_2;
	// $FF: renamed from: a boolean
	private boolean field_3;
	// $FF: renamed from: a java.awt.Button
	private Button field_4;
	// $FF: renamed from: a javax.swing.JFileChooser
	private JFileChooser field_5;
	// $FF: renamed from: a long
	private long field_6;
	// $FF: renamed from: a java.awt.Label[]
	private Label[] field_7;
	// $FF: renamed from: b java.awt.Label[]
	private Label[] field_8;
	// $FF: renamed from: c java.awt.Label[]
	private Label[] field_9;
	// $FF: renamed from: a java.awt.Label[][]
	private Label[][] field_10;
	// $FF: renamed from: b java.awt.Label[][]
	private Label[][] field_11;
	// $FF: renamed from: a java.awt.Label
	private Label field_12;
	// $FF: renamed from: b java.awt.Label
	private Label field_13;
	// $FF: renamed from: c java.awt.Label
	private Label field_14;
	// $FF: renamed from: a java.awt.TextField
	private TextField field_15;
	// $FF: renamed from: d java.awt.Label
	private Label field_16;
	// $FF: renamed from: e java.awt.Label
	private Label field_17;
	// $FF: renamed from: f java.awt.Label
	private Label field_18;
	// $FF: renamed from: g java.awt.Label
	private Label field_19;
	// $FF: renamed from: a int
	private int field_20;
	// $FF: renamed from: a java.lang.String
	private String field_21;
	// $FF: renamed from: a java.lang.String[]
	private String[] field_22;
	// $FF: renamed from: a int[]
	private int[] field_23;
	// $FF: renamed from: b int
	private int field_24;
	// $FF: renamed from: c int
	private int field_25;
	// $FF: renamed from: d int
	private int field_26;
	// $FF: renamed from: e int
	private int field_27;
	// $FF: renamed from: a java.lang.Thread
	private Thread field_28;
	// $FF: renamed from: a java.net.Socket
	private Socket field_29;
	// $FF: renamed from: b java.io.PrintWriter
	private PrintWriter field_30;
	// $FF: renamed from: a java.io.BufferedInputStream
	private BufferedInputStream field_31;
	//String for inputs (var7)
	private String inputs;


	// $FF: renamed from: <init> () void
	public read() {
		super();
		this.field_0 = null;
		this.field_4 = new Button("Data Logging: INACTIVE");
		this.field_6 = 0L;
		this.field_7 = new Label[8];
		this.field_8 = new Label[8];
		this.field_9 = new Label[8];
		this.field_10 = new Label[8][2];
		this.field_11 = new Label[8][2];
		this.field_12 = new Label("Name");
		this.field_13 = new Label("ID");
		this.field_14 = new Label("Sequence");
		this.field_15 = new TextField();
		this.field_16 = new Label("seconds", 1);
		this.field_17 = new Label("Update", 1);
		this.field_18 = new Label("Channel 1", 1);
		this.field_19 = new Label("Channel 2", 1);
		this.field_22 = new String[8];
		this.field_23 = new int[8];
		this.field_24 = 1;
		this.field_25 = 5;
		this.field_26 = 0;
		this.field_27 = 0;
		this.field_28 = null;
		this.field_29 = null;
		this.field_30 = null;
		this.field_31 = null;
	}

	public void init() {
		this.setLayout((LayoutManager)null);
		this.setBackground(Color.white);
		this.setSize(550, 380);
		this.field_12.setAlignment(1);
		this.field_12.setFont(new Font("Dialog", 0, 13));
		this.field_12.setBounds(15, 10, 67, 20);
		this.add(this.field_12);
		this.field_13.setAlignment(1);
		this.field_13.setFont(new Font("Dialog", 0, 13));
		this.field_13.setBounds(100, 10, 33, 20);
		this.add(this.field_13);
		this.field_14.setAlignment(1);
		this.field_14.setFont(new Font("Dialog", 0, 13));
		this.field_14.setBounds(145, 10, 67, 20);
		this.add(this.field_14);
		this.add(this.field_18);
		this.field_18.setForeground(Color.black);
		this.field_18.setFont(new Font("Dialog", 1, 13));
		this.field_18.setBounds(230, 10, 87, 20);
		this.add(this.field_19);
		this.field_19.setForeground(Color.black);
		this.field_19.setFont(new Font("Dialog", 1, 13));
		this.field_19.setBounds(380, 10, 87, 20);

		for(int var1 = 0; var1 < 8; ++var1) {
			this.field_7[var1] = new Label();
			this.field_7[var1].setText("--");
			this.field_7[var1].setAlignment(1);
			this.field_7[var1].setFont(new Font("Dialog", 1, 13));
			this.field_7[var1].setBounds(10, 40 + var1 * 30, 80, 20);
			this.add(this.field_7[var1]);
			this.field_8[var1] = new Label();
			this.field_8[var1].setText("-");
			this.field_8[var1].setAlignment(1);
			this.field_8[var1].setForeground(Color.black);
			this.field_8[var1].setFont(new Font("Dialog", 1, 13));
			this.field_8[var1].setBounds(100, 40 + var1 * 30, 33, 20);
			this.add(this.field_8[var1]);
			this.field_9[var1] = new Label();
			this.field_9[var1].setText("-");
			this.field_9[var1].setAlignment(1);
			this.field_9[var1].setForeground(Color.black);
			this.field_9[var1].setFont(new Font("Dialog", 1, 13));
			this.field_9[var1].setBounds(140, 40 + var1 * 30, 80, 20);
			this.add(this.field_9[var1]);

			for(int var2 = 0; var2 < 2; ++var2) {
				this.field_10[var1][var2] = new Label();
				this.field_10[var1][var2].setText("--");
				this.field_10[var1][var2].setAlignment(1);
				this.field_10[var1][var2].setBackground(new Color(176, 196, 222));
				this.field_10[var1][var2].setForeground(Color.white);
				this.field_10[var1][var2].setFont(new Font("Dialog", 1, 20));
				this.field_10[var1][var2].setBounds(230 + var2 * 150, 40 + var1 * 30, 87, 20);
				this.add(this.field_10[var1][var2]);
				this.field_11[var1][var2] = new Label();
				this.field_11[var1][var2].setText("--");
				this.field_11[var1][var2].setFont(new Font("Dialog", 1, 12));
				this.field_11[var1][var2].setBounds(320 + var2 * 150, 40 + var1 * 30, 60, 20);
				this.add(this.field_11[var1][var2]);
			}

			this.field_22[var1] = new String("--");
			this.field_23[var1] = 0;
		}

		this.add(this.field_4);
		this.field_4.setFont(new Font("Dialog", 1, 10));
		this.field_4.setBackground(Color.lightGray);
		this.field_4.setBounds(150, 310, 140, 25);
		this.add(this.field_17);
		this.field_17.setForeground(Color.black);
		this.field_17.setFont(new Font("Dialog", 1, 10));
		this.field_17.setBounds(150, 345, 40, 20);
		this.field_15.setText(Integer.toString(this.field_25));
		this.add(this.field_15);
		this.field_15.setForeground(Color.black);
		this.field_15.setFont(new Font("Dialog", 1, 10));
		this.field_15.setBounds(206, 345, 38, 20);
		this.add(this.field_16);
		this.field_16.setForeground(Color.black);
		this.field_16.setFont(new Font("Dialog", 1, 10));
		this.field_16.setBounds(250, 345, 48, 20);
		this.field_3 = false;
		this.field_6 = 0L;
		this.field_25 = 5;
		this.field_26 = 0;
	}

	public void start() {
		//this.field_20 = this.getParameter("ZBgrp").charAt(0) - 65 << 3;
		this.field_20 = 'A' - 65 << 3;

		for(int var1 = 0; var1 < 8; ++var1) {
			this.field_8[var1].setText(Integer.toString(this.field_20 + var1));
		}

		if((this.field_20 >> 3) + 1 >= 10) {
			this.field_21 = "0" + Integer.toString(((this.field_20 >> 3) + 1) / 10) + "0";
		} else {
			this.field_21 = "00" + (char)((this.field_20 >> 3) + 65);
		}

		if(this.field_28 == null) {
			this.field_28 = new Thread(this);
			this.field_28.start();
		}

	}

	public void stop() {
		if(this.field_28 != null) {
			this.field_28 = null;
		}

		if(this.field_29 != null) {
			try {
				this.field_29.close();
				return;
			} catch (Exception var2) {
				System.err.println("R" + this.field_20 + ": Error Closing Socket: " + var2);
			}
		}

	}

	public void run() {
		while(this.field_28 != null) {
			if(this.field_29 == null) {
				try {
					this.field_29 = new Socket("10.3.3.33", 1001);
					this.field_30 = new PrintWriter(this.field_29.getOutputStream(), true);
					this.field_31 = new BufferedInputStream(this.field_29.getInputStream());
				} catch (UnknownHostException var15) {
					System.err.println("R" + this.field_20 + ": Don\'t know about host: iServer.");
					continue;
				} catch (IOException var16) {
					System.err.println("R" + this.field_20 + ": Couldn\'t get connection - " + var16);
					continue;
				}
			}

			int var1 = 0;
			String var2 = new String("?");

			try {
				this.field_27 = 0;

				int var20;
				while(this.field_27 < 30) {
					if(this.field_27 % 5 == 0) {
						if(this.field_24 == 1) {
							this.field_30.println("EQNG" + this.field_21);
						} else {
							this.field_30.println("ERDG" + this.field_21);
						}
					}

					try {
						Thread.sleep(1000L);
					} catch (InterruptedException var14) {
						;
					}

					byte[] var3 = new byte[4096];
					boolean var4 = false;
					if((var20 = this.field_31.available()) > 0) {
						System.out.println("data in");
						if(this.field_31.read(var3, 0, var20) != 0) {
							System.out.println(var3[0]);
							if(var3[0] != 79 && var3[0] != 69 && var3[0] != 87 && var3[0] != 84) {
								var2 = new String(var3, 0, var20);
								StringTokenizer var18 = new StringTokenizer(var2, "\r\n");
								if(this.field_3 && this.field_24 == 0) {
									this.field_2.print(new Date() + ",");
								}

								while(var18.hasMoreTokens()) {
									String var7 = var18.nextToken();
									System.out.println(var7);
									StringTokenizer var6 = new StringTokenizer(var7, " ");
									
									inputs = var7;
									
									int var5 = 0;

									String[] var8;
									for(var8 = new String[11]; var6.hasMoreTokens(); var8[var5++] = var6.nextToken()) {
										;
									}

									if(var5 >= 3) {
										int var21;
										if((var21 = Integer.parseInt(var8[0])) < this.field_20 || var21 >= this.field_20 + 8) {
											continue;
										}

										if(this.field_24 == 1) {
											this.field_26 = 1;
											this.field_22[var21 & 7] = var7.substring(var8[0].length() + 1, var7.indexOf(var8[var5 - 2]) - 1);
											if(var8[var5 - 2].charAt(0) == 49) {
												this.field_23[var21 & 7] = 1;
											} else if(var8[var5 - 2].charAt(1) == 49) {
												this.field_23[var21 & 7] = 2;
											} else if(var8[var5 - 2].charAt(2) == 49) {
												this.field_23[var21 & 7] = 3;
											} else {
												this.field_23[var21 & 7] = 0;
											}

											++var1;
											continue;
										}

										if(var5 < 3) {
											continue;
										}

										this.field_7[var1].setText(this.field_22[var21 & 7]);
										this.field_7[var1].setVisible(true);
										this.field_8[var1].setVisible(true);
										this.field_8[var1].setText(var8[0]);
										if(this.field_23[var21 & 7] != 0) {
											if(this.field_23[var21 & 7] == 2) {
												var8[1] = "Lost";
											} else if(this.field_23[var21 & 7] == 3) {
												var8[1] = "ID";
											}

											this.field_9[var1].setVisible(true);
										}

										this.field_9[var1].setText(var8[1]);
										this.field_9[var1].setVisible(true);
										if(this.field_3 && this.field_24 == 0) {
											this.field_2.print(var8[0] + "," + var8[1] + "," + var8[2] + ",");
										}

										var21 = Integer.parseInt(var8[2]);
										int var22 = 0;
										if(var5 > 3) {
											for(int var9 = 3; var9 < var5; ++var22) {
												if(var21 == 25) {
													this.field_10[var1][1].setVisible(false);
													this.field_11[var1][1].setVisible(false);
												} else if(var21 == 26) {
													var22 = 1;
													this.field_10[var1][0].setVisible(false);
													this.field_11[var1][0].setVisible(false);
												}

												this.field_10[var1][var22].setVisible(true);
												this.field_11[var1][var22].setVisible(true);
												this.field_10[var1][var22].setText(var8[var9]);
												this.field_11[var1][var22].setText(var8[var9 + 1]);
												Color var10;
												switch(var22) {
												case 0:
													var10 = Color.red;
													break;
												default:
													var10 = new Color(0, 153, 0);
												}

												this.field_10[var1][var22].setForeground(var10);
												this.field_11[var1][var22].setForeground(var10);
												if(this.field_3 && this.field_24 == 0) {
													this.field_2.print(var8[var9] + "," + var8[var9 + 1] + ",");
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

								if(this.field_3 && this.field_24 == 0) {
									this.field_2.print("\n");
									this.field_2.flush();
								}

								this.field_6 = (this.field_6 + 1L) % Long.MAX_VALUE;
							}

							this.field_27 = 100;
						}
					} else if(var20 == 0) {
						++this.field_27;
					} else {
						this.field_27 = 50;
					}
				}

				if(this.field_25 > 100 || this.field_27 == 30 && this.field_29 != null) {
					try {
						System.err.println(new Date() + " R" + this.field_20 + " nodata; port:" + this.field_29.getLocalPort());
						this.field_29.close();
					} catch (Exception var13) {
						System.err.println("R" + this.field_20 + ": Error Closing Socket: " + var13);
					}

					this.field_29 = null;
				}

				int var19;
				for(var19 = var1; var19 < 8; ++var19) {
					this.field_7[var19].setVisible(false);
					this.field_8[var19].setVisible(false);
					this.field_9[var19].setVisible(false);

					for(var20 = 0; var20 < 2; ++var20) {
						this.field_10[var19][var20].setVisible(false);
						this.field_11[var19][var20].setVisible(false);
					}
				}

				if(this.field_24 == 0 && this.field_6 % 20L == 0L) {
					this.field_24 = 1;
					this.field_26 = 0;
				} else if(this.field_24 == 0) {
					try {
						for(var19 = 0; var19 < this.field_25; ++var19) {
							Thread.sleep(1000L);
						}
					} catch (InterruptedException var11) {
						;
					}
				} else if(this.field_24 == 1 && this.field_26 == 1) {
					this.field_24 = 0;

					try {
						for(var19 = 0; var19 < this.field_25; ++var19) {
							Thread.sleep(1000L);
						}
					} catch (InterruptedException var12) {
						;
					}
				}
			} catch (Exception var17) {
				System.err.println("R" + this.field_20 + ": Error reading socket: " + var17 + "--" + var2);
			}
			
			double level = 0;
                        String[] inputsStr = inputs.split(" ");
                        level = Double.parseDouble(inputsStr[3]);
                        
                        System.out.println("level: " + level);
                        
                        try{
                            String pass = new Password().password;
                            String address = "http://localhost/write.php";
                            Date dconn = new Date();
                            SimpleDateFormat dform = new SimpleDateFormat("yyyy:MM:dd:HH:mm");
                            String date = dform.format(dconn);
                            String data = date +"," + level;
                            URL url = new URL(address + "?authcode=" + pass + "&data=" + data);
                            URLConnection request = url.openConnection();
                    } catch (IOException e) {
                            e.printStackTrace();
                    }
		}

	}

	public boolean action(Event var1, Object var2) {
		if(var1.target instanceof Button) {
			if(var2.toString().substring(0, 12).compareTo("Data Logging") == 0) {
				JDialog var4;
				if(!this.field_3) {
					this.field_5 = new JFileChooser();
					if(this.field_5.showSaveDialog(this) == 0) {
						if(this.field_0 != null) {
							this.field_2.close();
						}

						if(this.field_5.getSelectedFile().getName().lastIndexOf(46) == -1) {
							this.field_5.setSelectedFile(new File(this.field_5.getSelectedFile().getAbsoluteFile() + ".csv"));
						} else if(!this.field_5.getSelectedFile().getName().endsWith(".csv")) {
							(var4 = new JDialog()).setTitle("Save Current Graph");
							var4.add(new Label("File Type Error: file must be saved in TEXT format(.csv)"));
							var4.resize(330, 80);
							var4.show();
						}

						if(this.field_5.getSelectedFile().getName().endsWith(".csv")) {
							this.field_0 = this.field_5.getSelectedFile();

							try {
								this.field_1 = new FileWriter(this.field_0);
								this.field_2 = new PrintWriter(this.field_1);
							} catch (IOException var3) {
								System.err.println("R" + this.field_20 + ": IOException:");
								var3.printStackTrace();
								return false;
							}

							this.field_3 = true;
							this.field_4.setLabel("Data Logging: ACTIVE");
							this.field_6 = 0L;
							(var4 = new JDialog()).setTitle("Data Logging");
							var4.setLayout(new FlowLayout());
							var4.add(new Label("Data logging in " + this.field_0));
							var4.resize(500, 80);
							var4.show();
						}
					} else {
						(var4 = new JDialog()).setTitle("Data Logging");
						var4.setLayout(new FlowLayout());
						var4.add(new Label("Data logging inactivated"));
						var4.resize(230, 80);
						var4.show();
					}
				} else {
					this.field_3 = false;
					this.field_4.setLabel("Data Logging: INACTIVE");
					if(this.field_2 != null) {
						this.field_2.close();
					}

					this.field_0 = null;
					(var4 = new JDialog()).setTitle("Data Logging");
					var4.setLayout(new FlowLayout());
					var4.add(new Label("Data logging inactivated"));
					var4.resize(230, 80);
					var4.show();
				}
			}
		} else if(var1.target == this.field_15) {
			this.field_25 = Integer.parseInt(this.field_15.getText());
			if(this.field_25 < 1) {
				this.field_25 = 1;
			} else if(this.field_25 > 86400) {
				this.field_25 = 86400;
			}

			this.field_15.setText(Integer.toString(this.field_25));
			return true;
		}

		return true;
	}
}
