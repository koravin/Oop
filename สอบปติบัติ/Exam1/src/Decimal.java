import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Decimal {

	protected Shell shell;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Decimal window = new Decimal();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(141, 10, 145, 15);
		label.setText("กรุณากรอกข้อมูลเลขฐาน 10");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(65, 39, 286, 65);
		
		//ปุ่มเคลียค่าหน้าจอ
		Button btn_Re = new Button(shell, SWT.NONE);
		btn_Re.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		btn_Re.setForeground(SWTResourceManager.getColor(255, 0, 0));
		btn_Re.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
	            text.setText("");
			}
		});
		btn_Re.setBounds(38, 122, 97, 38);
		btn_Re.setText("รีรีรี");
		
		//แปลงเลขฐาน10 เป็นฐาน 2
		Button btn10To2 = new Button(shell, SWT.NONE);
		btn10To2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		        String input = text.getText();
		        if (input == null || input.isEmpty() || !isDEcimalNumber(input)) {
		            text.setText("กรุณากรอกเลขฐานสิบ"); //ตรวจสอบว่าค่าที่รับเข้ามาเป็นเลขฐาน 8 หรือค่าว่างหรือเปล่า
		        } else {
		            int decimal = Integer.parseInt(input);
		            String binary = Integer.toBinaryString(decimal);
		            text.setText(binary);
		        }
		    }

			//ฟังก์ชันตรวจสอบว่าเป็นเลขฐาน 10 หรือไม่
		    public boolean isDEcimalNumber(String input) {
		        for (char c : input.toCharArray()) {
		            if (c < '0' || c > '9') {
		                return false;
		            }
		        }
		        return true;
		    }
			
		});
		btn10To2.setBounds(38, 176, 97, 38);
		btn10To2.setText("10to2");
		
		
		//ปุ่มแปลงเลขฐาน 10 ไป 8
		Button btn10To8 = new Button(shell, SWT.NONE);
		btn10To8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		        String input = text.getText();
		        if (input == null || input.isEmpty() || !isDEcimalNumber(input)) {
		            text.setText("กรุณากรอกเลขฐานสิบ"); //ตรวจสอบว่าค่าที่รับเข้ามาเป็นเลขฐาน 8 หรือค่าว่างหรือเปล่า
		        } else {
		            int decimal = Integer.parseInt(input);
		            String octal = Integer.toOctalString(decimal);
		            text.setText(octal);
		        }
		    }

			//ฟังก์ชันตรวจสอบว่าเป็นเลขฐาน 10 หรือไม่
		    public boolean isDEcimalNumber(String input) {
		        for (char c : input.toCharArray()) {
		            if (c < '0' || c > '9') {
		                return false;
		            }
		        }
		        return true;
		    }
			
		});
		btn10To8.setText("10to8");
		btn10To8.setBounds(175, 176, 97, 38);
		
		
		//ปุ่มแปลงเลขฐาน 10 ไป 16
		Button btn10To16 = new Button(shell, SWT.NONE);
		btn10To16.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		        String input = text.getText();
		        if (input == null || input.isEmpty() || !isDEcimalNumber(input)) {
		            text.setText("กรุณากรอกเลขฐานสิบ"); //ตรวจสอบว่าค่าที่รับเข้ามาเป็นเลขฐาน 8 หรือค่าว่างหรือเปล่า
		        } else {
		            int decimal = Integer.parseInt(input);
		            String hex = Integer.toString(decimal, 16);
		            text.setText(hex);
		        }
		    }

			//ฟังก์ชันตรวจสอบว่าเป็นเลขฐาน 10 หรือไม่
		    public boolean isDEcimalNumber(String input) {
		        for (char c : input.toCharArray()) {
		            if (c < '0' || c > '9') {
		                return false;
		            }
		        }
		        return true;
				
			}
		});
		btn10To16.setText("10to16");
		btn10To16.setBounds(304, 176, 97, 38);
		
		//ปุ่มกลับหน้าหลัก
		Button btn_Coming_Home_To_You = new Button(shell, SWT.NONE);
		btn_Coming_Home_To_You.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		        shell.dispose();
		        // Open Practice form
		        Practice practice = new Practice();
		        practice.open();
			}
		});
		btn_Coming_Home_To_You.setText("กลับหน้าหลัก");
		btn_Coming_Home_To_You.setBounds(175, 123, 97, 38);
		
		


	}
}
