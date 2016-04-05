// Disclaimer: IMPORTANT: This software was developed at the National
// Institute of Standards and Technology by employees of the Federal
// Government in the course of their official duties. Pursuant to
// title 17 Section 105 of the United States Code this software is not
// subject to copyright protection and is in the public domain. This
// is an experimental system. NIST assumes no responsibility
// whatsoever for its use by other parties, and makes no guarantees,
// expressed or implied, about its quality, reliability, or any other
// characteristic. We would appreciate acknowledgement if the software
// is used. This software can be redistributed and/or modified freely
// provided that any derivative works bear some notice that they are
// derived from it, and any modified versions bear some notice that
// they have been modified.

package main.java.gov.nist.isg.tracking.display;

import java.awt.*;

import ij.ImagePlus;
import ij.ImageStack;
import ij.gui.Overlay;
import ij.gui.TextRoi;
import ij.process.ImageProcessor;

/**
 * Created by mmajursk on 6/11/2014.
 */
public class OverlayObjectLabels {

  public static ImagePlus overlayLabels(ImagePlus imp) {

    Overlay o = new Overlay();
    ImageStack is = imp.getStack();

    for(int k = 0; k < is.getSize(); k++ ) {

      ImageProcessor ip = is.getProcessor(k+1);
      // compute the label centroids
      int maxVal = 0;
      int nb = ip.getWidth() * ip.getHeight();
      for (int i = 0; i < nb; i++) {
        maxVal = Math.max(maxVal, ip.get(i));
      }

      double[] xCent = new double[maxVal + 1];
      double[] yCent = new double[maxVal + 1];
      double[] size = new double[maxVal + 1];

      for (int y = 0; y < ip.getHeight(); y++) {
        for (int x = 0; x < ip.getWidth(); x++) {
          int val = ip.get(x, y);
          if (val > 0) {
            xCent[val] += x;
            yCent[val] += y;
            size[val]++;
          }
        }
      }

      for (int i = 1; i < xCent.length; i++) {
        xCent[i] /= size[i];
        yCent[i] /= size[i];
      }

      double avgSize = 0;
      nb = 0;
      for (int i = 1; i < xCent.length; i++) {
        if(size[i] > 0) {
          avgSize += size[i];
          nb++;
        }
      }
      avgSize /= nb;
      int fontSize = (int) (1.5*Math.sqrt(avgSize/Math.PI));
      fontSize = Math.max(fontSize, 6);
      fontSize = Math.min(fontSize, 18);


      for (int i = 1; i < xCent.length; i++) {
        if(size[i] > 0 ) {
          TextRoi
              roi =
              new TextRoi(xCent[i], yCent[i], (new Integer(i)).toString(),
                          (new Font(Font.MONOSPACED, Font.PLAIN, fontSize)));
          roi.setJustification(TextRoi.CENTER);
          Rectangle r = roi.getBounds();
          roi.setLocation(xCent[i] - (r.getWidth() / 2) + 1, yCent[i] - (r.getHeight() / 2) + 1);

          roi.setPosition(k + 1);
          o.addElement(roi);
        }
      }

    }
    imp.setOverlay(o);

    return imp;
  }

}
