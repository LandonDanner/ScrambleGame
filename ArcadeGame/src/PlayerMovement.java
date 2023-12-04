public class Player extends Canvas implements KeyListener {
  private String keys_typed;
	private String key;
  public Player() {
    key = "NO KEY PRESSED YET";
		keys_typed = "";
		addKeyListener( this ); /*all keyListeners must have this in the constructor*/
		setFocusable( true );
}
  public void paint(Graphics window) {
    Image ship = Toolkit.getDefaultToolkit().getImage("PlayerShip.png");
    window.drawImage(ship, 50, 100, 60, 20, this);
  }
  public void keyTyped(KeyEvent e)
	{
		keys_typed += "" + e.getKeyChar();
		repaint();
	}
	
	/*2*/
	public void keyPressed(KeyEvent e)
	{
		/*KeyEvent key codes: https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html */
		if(e.getKeyCode() == KeyEvent.VK_RIGHT ) {
			key = ">>>>>>";
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT ) {
			key = "<<<<<<";
		}
		//add another else if to check if another key was pressed..
		else {
			key = "Key " + e.getKeyCode() + " is pressed!";
		}
		repaint();
	}
	
	/*3*/	
	public void keyReleased(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_RIGHT ) {
			key = "The right arrow key was released!";
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT ) {
			key = "The left arrow key was released!";
		}
		//add another else if to check if another key was released..
		else{
			key = "Key "+ e.getKeyCode() +" was released!";
		}
		repaint();
		
	}
}
