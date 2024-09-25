package edu.grinnell.csc207.blocks;


public class Circle implements AsciiBlock {
   
  //fields
  String unitchar;
  int diameter;
  
  //Constructors
  public Circle(char unitchar, int diameter){
  
    this.unitchar = Character.toString(unitchar);
    this.diameter = diameter;
  }

  public Circle(int diameter){
    this(' ', diameter);
  }

  //Methods
  public String row(int i){
    
    String result = "";
    double center = (diameter - 1)/2.0;
    for(double x = 0; x < diameter; x++)
    { 
      if (Math.pow((center-x),2) + Math.pow((i - center),2) <= Math.pow(diameter/2.0,2))
      {
       result += unitchar;
      }
      else
       {result += " ";}
    }
    return result;
  }

  public int height(){
    return this.diameter;
  }

  public int width(){
    return this.diameter;
  }

  public boolean eqv(AsciiBlock other){
    return other.width() == this.width() &&
           other.height() == this.height();
           //other.unitchar.equals(this.unitchar) &&    
           //other.diameter == this.diameter;  
  }

}
