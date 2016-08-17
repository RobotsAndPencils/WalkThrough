Walkthrough
===========

An Android library to facilitate navigation of a hierarchy of pages representing a tutorial or walkthrough to show off a series of app features.

<img src="https://github.com/RobotsAndPencils/WalkThrough/raw/master/images/screenshot.png" width="320" height="599" />


Usage
-----

Pages can be constructed using the Page class by providing an object that is descended from the WalkThroughView class (in the example below: WalkThroughScreenView) and is setup with the appropriate content and button options. The Page can also be provided with an optional page list for sub pages.

Example:
```java
@NonNull
public List<Page> getScreens() {
    WalkThroughScreenView screen1 = new WalkThroughScreenView(mContext).setMessage("Card wallet feature")
            .showClose(true);

    WalkThroughScreenView screen2 = new WalkThroughScreenView(mContext).setMessage("Low on data each month?")
            .showClose(true)
            .showNext(true);

    WalkThroughScreenView screen2a = new WalkThroughScreenView(mContext).setMessage("Select the allowances tab")
            .showBack(true)
            .showClose(true);
    WalkThroughScreenView screen2b = new WalkThroughScreenView(mContext).setMessage("Click on the tariff title")
            .showBack(true)
            .showClose(true);
    WalkThroughScreenView screen2c = new WalkThroughScreenView(mContext).setMessage("and change your tariff")
            .showBack(true)
            .showClose(true);

    List<Page> page2List = new ArrayList<>();
    page2List.add(new Page(screen2a, null));
    page2List.add(new Page(screen2b, null));
    page2List.add(new Page(screen2c, null));

    Page page1 = new Page(screen1, null);
    Page page2 = new Page(screen2, page2List);

    List<Page> pages = new ArrayList<>();
    pages.add(page1);
    pages.add(page2);

    return pages;
}
```
The list of pages can then be assembled with a call to LayoutConfiguration.Builder.build() whose result can in turn be provided to the WalkThroughManager.start() method along with a WalkThroughManager.Listener for actions upon closing the WalkThrough:
```java
WalkThroughManager mWalkThroughManager;
...
LayoutConfiguration layoutConfiguration = new LayoutConfiguration.Builder()
        .addLayouts(getScreens())
        .build();
mWalkThroughManager.start(mContext, layoutConfiguration, responseTag -> onClose(responseTag));
```

The WalkThrough will then be presented in the app and the User can navigate from screen to screen by swiping left or right. A circle page indicator appears at the bottom of each page to show progress through the WalkThrough. Elements within the contents of the current page can be hooked up to the WalkThroughView.nextWalkThrough() method to go to a series of sub-pages that expand on the contents of the current page.


Download
--------

Grab via Gradle:
```groovy
compile ' com.robotsandpencils.walkthrough:walkthrough:2.5.2'
```


License
--------

    MIT License

    Copyright (c) 2016 Robots and Pencils

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.

 [1]: https://github.com/RobotsAndPencils
