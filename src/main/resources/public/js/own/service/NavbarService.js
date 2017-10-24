(function () {
    'use strict';
    angular
        .module('app')
        .factory('NavbarService', NavbarService);

    function NavbarService() {

        var tab;

        return {
            setSelectedTab: setSelectedTab,
            getSelectedTab: getSelectedTab
        };

        function setSelectedTab(selectedTab) {
            this.tab = selectedTab;
        }

        function getSelectedTab() {
            return this.tab;
        }
    }

}());