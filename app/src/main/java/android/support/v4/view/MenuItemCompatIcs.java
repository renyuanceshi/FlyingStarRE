package android.support.v4.view;

import android.view.MenuItem;

class MenuItemCompatIcs {

    static class OnActionExpandListenerWrapper implements MenuItem.OnActionExpandListener {
        private SupportActionExpandProxy mWrapped;

        public OnActionExpandListenerWrapper(SupportActionExpandProxy supportActionExpandProxy) {
            this.mWrapped = supportActionExpandProxy;
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.mWrapped.onMenuItemActionCollapse(menuItem);
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.mWrapped.onMenuItemActionExpand(menuItem);
        }
    }

    interface SupportActionExpandProxy {
        boolean onMenuItemActionCollapse(MenuItem menuItem);

        boolean onMenuItemActionExpand(MenuItem menuItem);
    }

    MenuItemCompatIcs() {
    }

    public static boolean collapseActionView(MenuItem menuItem) {
        return menuItem.collapseActionView();
    }

    public static boolean expandActionView(MenuItem menuItem) {
        return menuItem.expandActionView();
    }

    public static boolean isActionViewExpanded(MenuItem menuItem) {
        return menuItem.isActionViewExpanded();
    }

    public static MenuItem setOnActionExpandListener(MenuItem menuItem, SupportActionExpandProxy supportActionExpandProxy) {
        return menuItem.setOnActionExpandListener(new OnActionExpandListenerWrapper(supportActionExpandProxy));
    }
}
