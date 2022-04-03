# NavigationAndFragments
A use case for fragments and navigation using intents.

## To implement this use case, follow these steps : 

1) Navigate to the activity class xml file and add a new `FragmentComponent` Ui view tag 
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
2) Create a new fragment class :
```kt
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.last.databinding.FragmentBlankBinding

class BlankFragment : Fragment(R.layout.fragment_blank) {

    private lateinit var binding: FragmentBlankBinding
  
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // to init binding in fragments we use bind
        binding = FragmentBlankBinding.bind(view)
    }
}
```
3) Inflate the 

## Classes References :
- A `Fragment` : 
- A `FragmentComponent` : 




