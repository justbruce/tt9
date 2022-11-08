package io.github.sspanak.tt9.preferences;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import io.github.sspanak.tt9.R;
import io.github.sspanak.tt9.db.DictionaryLoader;
import io.github.sspanak.tt9.ui.DictionaryLoadingBar;

public class PreferencesActivity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setTheme();
		buildScreen();
	}


	private void setTheme() {
		AppCompatDelegate.setDefaultNightMode(
			SettingsStore.getInstance().getDarkTheme() ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO
		);
	}


	private void buildScreen() {
		setContentView(R.layout.preferences_container);
		getSupportFragmentManager()
			.beginTransaction()
			.replace(R.id.preferences_container, new PreferencesFragment(this))
			.commit();
	}


	DictionaryLoadingBar getDictionaryProgressBar() {
		return DictionaryLoadingBar.getInstance(this);
	}


	DictionaryLoader getDictionaryLoader() {
		return DictionaryLoader.getInstance(this);
	}
}