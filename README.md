# NavigationAndFragments
A use case for fragments and navigation.

## To implement this use case, follow these steps : 

1) Create a new fragment navigation xml file with id `main_nav`:
```xml
<?xml version="1.0" encoding="utf-8"?>
<navigation xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main_nav">
</navigation>
```

2) Navigate to the activity class xml file and add a new `FragmentContainerView` Ui view tag and add the property `app:navGraph` with the 
navigation file id `main_nav`, now the navigation controller will adapt and render its data on the `FragmentContainerView` on runtime :
```xml
<androidx.fragment.app.FragmentContainerView
    android:id="@+id/nav_host_fragment"
    android:name="androidx.navigation.fragment.NavHostFragment"
    android:layout_width="0dp"
    android:layout_height="0dp"
    app:defaultNavHost="true"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintLeft_toLeftOf="parent"
    app:layout_constraintRight_toRightOf="parent"
    app:layout_constraintTop_toTopOf="parent"
    app:navGraph="@navigation/main_nav" />
```

3) Add 2 fragment placeholders xml tags in the above navigation tag with these respective Ids and setup a navigation action for 
each fragment with an id and destination parameters :
```xml 
    <fragment
        android:id="@+id/blankFragment"
        android:name="com.example.last.BlankFragment"
        android:label="fragment_blank"
        tools:layout="@layout/fragment_blank" >
        <action
            android:id="@+id/action_blankFragment_to_secondFragment"
            app:destination="@id/secondFragment" />
    </fragment>
    <fragment
        android:id="@+id/secondFragment"
        android:name="com.example.last.SecondFragment"
        android:label="fragment_second"
        tools:layout="@layout/fragment_second" >
        <action
            android:id="@+id/action_secondFragment_to_blankFragment"
            app:destination="@id/blankFragment" />
    </fragment>
```
4) Add a start destination property for default fragment to be rendered on application start and define the id for the start fragment : 
```xml
    app:startDestination="@id/blankFragment"
```
5) Create 2 new fragments, file > create new > fragment > fill in your options.

6) Add buttons to control the navigation between fragments : 
- Those are our 2 fragments and their respective designs and naviagtion controllers : 
```xml 
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".BlankFragment">

    <Button
        android:id="@+id/btn_next"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/next" />
</LinearLayout>
```
```xml  
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".SecondFragment">
    <ImageView
        android:id="@+id/imageView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:contentDescription="@string/image"
        android:src="@drawable/ic_launcher_background" />
    <Button
        android:id="@+id/btn_previous"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/previous" />
</LinearLayout>
```
7) Add listeners for our buttons (`btn_next` and `btn_previous`) to control our fragment navigation : 
- Get the navigation view instance (`main_nav`) from the child fragment view :
```kt
navController = Navigation.findNavController(view)
```
- Add a button listener and fire the navigation actions defined under each fragment : 
```kt 
binding.btnNext.setOnClickListener {
    navController.navigate(R.id.action_blankFragment_to_secondFragment)
}
```

## Classes References :
- A `Fragment` : A Fragment represents a reusable portion of your app's UI. A fragment defines and manages its own layout, has its own lifecycle, and can handle its own input events. Fragments cannot live on their own--they must be hosted by an activity or another fragment.

- A `FragmentContainerView` :  is a customized Layout designed specifically for Fragments. It extends FrameLayout, so it can reliably handle Fragment Transactions, and it also has additional features to coordinate with fragment behavior.

- Notice : FragmentContainerView will only allow views returned by a Fragment's `Fragment.onCreateView`. Attempting to add any other view will result in an IllegalStateException.
