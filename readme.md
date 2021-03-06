# Lineage Mapper

Welcome to Lineage Mapper - the National Institute of Standards and Technology's Cell Tracking application, developed by the Information Technology Laboratory-Software and Systems Division at NIST Gaithersburg.

We developed an open source, highly accurate, overlap-based cell tracking system that tracks live cells across a set of time-lapse images. The processing pipeline of the Lineage mapper is shown in Figure 1. The Lineage Mapper successfully detects dynamic single cell behavior: cell migration, changes in cell state (mitosis, apoptosis); cells within colonies or the entire colonies, cells within cell sheets or cells moving around with high cell-cell contact.


![LM Pipeline](../../wiki/imgs/LM_Processing_Pipeline.png)

Figure 1: Lineage Mapper processing pipeline and tracking outputs. The algorithmic steps consists of: (1) compute cost between cells from consecutive frames, (2) detect cell collision and account for it, (3) detect mitosis events, (4) assign tracks between cells, and (5) create tracking outputs. The outputs includes saved tracked images, the cell lineage plotting and 4 tracking output measurements: (1) confidence index, (2) the birth and death matrix, (3) the mitosis matrix, (4) the fusion matrix.

This repository contains source code for the plugin in one branch and the source code for the MATLAB prototype in another.

# Quick Navigation

#### - [About Lineage Mapper](https://isg.nist.gov/deepzoomweb/resources/csmet/pages/cell_tracking/cell_tracking.html)
#### - [Wiki](https://github.com/USNISTGOV/Lineage-Mapper/wiki)
#### - [User Guide](https://github.com/USNISTGOV/Lineage-Mapper/wiki/User-Guide)


## Sample Data Sets

We have an example dataset of segmented images and the tracking results. Included are the parameters used to generate the included tracking results. 

The dataset can be downloaded from the following link:

[LineageMapper_Test_Data.zip ~ 55 KB](../../wiki/testdata/LineageMapper_Test_Data.zip)

## Utilities

We have a ImageJ/Fiji plugin for converting binary images into labeled images using connected components labeling.

This plugin can be downloaded from the following link:

[Connected_Components_Labeling.jar ~ 6 KB](../../wiki/utilities/Connected_Components_Labeling.jar)



