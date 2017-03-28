package location;

public interface ILocation {
	/**
	   * @brief getter for X value
	   * @return int
	   */
  public int GetX();
	  /**
	   * @brief getter for Y value
	   * @return int
	   */
  public int GetY();
	  /**
	   * @brief setter for X value
	   * @param x
	   * @return void
	   */
  public void SetX(int _x);
	  /**
	   * @brief setter for Y value
	   * @param y
	   * @return void
	   */
  public void SetY(int _y);
	  
	    /**
	   * @brief setter for X and Y value simultaneously
	   * @param X
	   * @param y
	   * @return void
	   */
  public void SetXY(int _x,int _y);
}
