import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Octal {

	protected Shell shell;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Octal window = new Octal();
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
		label.setBounds(157, 22, 115, 15);
		label.setText("กรุณากรอกเลขฐาน 8");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(99, 43, 226, 61);
		
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
		
		//ปุ่มแปลงเลขฐาน 8 เป็นเลขฐาน 2
		Button btn8To2 = new Button(shell, SWT.NONE);
		btn8To2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		        String input = text.getText();
		        if (input == null || input.isEmpty() || !isOctalNumber(input)) {
		            text.setText("กรุณากรอกเลขฐานแปด"); //ตรวจสอบว่าค่าที่รับเข้ามาเป็นเลขฐาน 8 หรือค่าว่างหรือเปล่า
		        } else {
		            int decimal = Integer.parseInt(input, 8);
		            String binary = Integer.toBinaryString(decimal);
		            text.setText(binary);
		        }
		    }

			//ฟังก์ชันตรวจสอบว่าเป็นเลขฐาน 8 หรือไม่
		    public boolean isOctalNumber(String input) {
		        for (char c : input.toCharArray()) {
		            if (c < '0' || c > '7') {
		                return false;
		            }
		        }
		        return true;
		    }
			
		});
		btn8To2.setBounds(38, 167, 97, 38);
		btn8To2.setText("8to2");
		
		//ปุ่มแปลงเลขฐาน 8 เป็นเลขฐาน 10
		Button btn8To10 = new Button(shell, SWT.NONE);
		btn8To10.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		        String input = text.getText();
		        if (input == null || input.isEmpty() || !isOctalNumber(input)) {
		            text.setText("กรุณากรอกเลขฐานแปด"); //ตรวจสอบว่าค่าที่รับเข้ามาเป็นเลขฐาน 8 หรือค่าว่างหรือเปล่า
		        } else {
		            int decimal = Integer.parseInt(input, 8);
		            String octal = Integer.toString(decimal);
		            text.setText(octal);
		        }
		    }

			//ฟังก์ชันตรวจสอบว่าเป็นเลขฐาน 8 หรือไม่
		    public boolean isOctalNumber(String input) {
		        for (char c : input.toCharArray()) {
		            if (c < '0' || c > '7') {
		                return false;
		            }
		        }
		        return true;
		    }
				
			
		});
		btn8To10.setText("8to10");
		btn8To10.setBounds(157, 167, 97, 38);
		
		
		//ปุ่มแปลงเลขฐาน 8 เป็นเลขฐาน 16
		Button btn8To16 = new Button(shell, SWT.NONE);
		btn8To16.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		        String input = text.getText();
		        if (input == null || input.isEmpty() || !isOctalNumber(input)) {
		            text.setText("กรุณากรอกเลขฐานแปด"); //ตรวจสอบว่าค่าที่รับเข้ามาเป็นเลขฐาน 8 หรือค่าว่างหรือเปล่า
		        } else {
		            int decimal = Integer.parseInt(input, 8);
		            String hex = Integer.toHexString(decimal);
		            text.setText(hex);
		        }
		    }

			//ฟังก์ชันตรวจสอบว่าเป็นเลขฐาน 8 หรือไม่
		    public boolean isOctalNumber(String input) {
		        for (char c : input.toCharArray()) {
		            if (c < '0' || c > '7') {
		                return false;
		            }
		        }
		        return true;
			}
		});
		btn8To16.setText("8to16");
		btn8To16.setBounds(274, 167, 97, 38);
		
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
		btn_Coming_Home_To_You.setBounds(157, 122, 97, 38);
		
	

	}

}
