Walkthrough
===========

An Android library to facilitate navigation of a hierarchy of pages representing a tutorial or walkthrough to show off a series of app features.

![](https://www.dropbox.com/s/7ulfljovasvrbo4/Screenshot%202016-08-17%2011.23.28.png?dl=0)


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

    Copyright 2016 Robots And Pencils, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


 [1]: https://github.com/RobotsAndPencils
