import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Hex {

	protected Shell shell;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Hex window = new Hex();
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
		label.setBounds(152, 10, 141, 15);
		label.setText("กรุณากรอกเลขฐาน 16");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(48, 31, 320, 60);
		
		//ปุ่มเคลียหน้าจอ
		Button btn_Re = new Button(shell, SWT.NONE);
		btn_Re.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		btn_Re.setForeground(SWTResourceManager.getColor(255, 0, 0));
		btn_Re.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
	            text.setText("");
			}
		});
		btn_Re.setBounds(48, 111, 97, 38);
		btn_Re.setText("รีรีรี");
		
		
		//ปุ่มแปลงเลขฐาน 16 เป็นฐาน 2
		Button btn16To2 = new Button(shell, SWT.NONE);
		btn16To2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String input = text.getText();
				if (input.isEmpty() || !isHexNumber(input)) {
					text.setText("กรุณากรอกเลขฐานสิบหก");
				} else {
					int decimal = Integer.parseInt(input, 16);
					String binary = Integer.toBinaryString(decimal);
					text.setText(binary);
				}
			}

			//เมธธอดตรวจสอบว่าค่าที่รับเข้ามาเป็นเลขฐาน 16 หรือเปล่า
		    public boolean isHexNumber(String input) {
		        for (char c : input.toCharArray()) {
		            if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) {
		                return false;
		            }
		        }
		        return true;
			}
		});
		btn16To2.setBounds(48, 165, 97, 38);
		btn16To2.setText("16to2");
		
		
		//ปุ่มแปลงเลขฐาน 16 เป็นฐาน 8
		Button btn16To8 = new Button(shell, SWT.NONE);
		btn16To8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String input = text.getText();
				if (input.isEmpty() || !isHexNumber(input)) {
					text.setText("กรุณากรอกเลขฐานสิบหก");
				} else {
					int decimal = Integer.parseInt(input, 16);
					String octal = Integer.toOctalString(decimal);
					text.setText(octal);
				}
			}

			//เมธธอดตรวจสอบว่าค่าที่รับเข้ามาเป็นเลขฐาน 16 หรือเปล่า
		    public boolean isHexNumber(String input) {
		        for (char c : input.toCharArray()) {
		            if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) {
		                return false;
		            }
		        }
		        return true;
			}
		});
		btn16To8.setText("16to8");
		btn16To8.setBounds(180, 165, 97, 38);
		
		Button btn16To10 = new Button(shell, SWT.NONE);
		btn16To10.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String input = text.getText();
				if (input.isEmpty() || !isHexNumber(input)) {
					text.setText("กรุณากรอกเลขฐานสิบหก");
				} else {
					int decimal = Integer.parseInt(input, 16);
					text.setText(Integer.toString(decimal));//แสดงค่าเลขฐาน10ในหน้าจอ
				}
			}

			//เมธธอดตรวจสอบว่าค่าที่รับเข้ามาเป็นเลขฐาน 16 หรือเปล่า
		    public boolean isHexNumber(String input) {
		        for (char c : input.toCharArray()) {
		            if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) {
		                return false;
		            }
		        }
		        return true;
			}
		});
		btn16To10.setText("16to10");
		btn16To10.setBounds(314, 165, 97, 38);
		
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
		btn_Coming_Home_To_You.setBounds(180, 112, 97, 38);

	}

}
